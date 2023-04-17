package com.neoris.bank.service.impl;

import com.neoris.bank.configs.MsEmailConfig;
import com.neoris.bank.mappers.ClienteMapper;
import com.neoris.bank.dto.ClientDTO;
import com.neoris.bank.exception.MiExcepcionPerzonalizada;
import com.neoris.bank.mappers.JmsEmailMapper;
import com.neoris.bank.model.ClientEntity;
import com.neoris.bank.prodicer.IEmailProduce;
import com.neoris.bank.repository.ClientRepository;
import com.neoris.bank.service.IClientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
@AllArgsConstructor
public class ClientServiceImpl implements IClientService {


    private final ClientRepository clientRepository;

    private final IEmailProduce iEmailProduce;

    private final MsEmailConfig msEmailConfig;

    @Override
    @Transactional
    @CacheEvict(value = "cacheClient", allEntries = true)
    public ResponseEntity creatClient(ClientDTO clientDTO) {

        log.debug(
                "creatClient() request data: \n{}",
                clientDTO
        );

        clientRepository
                .findByIdentificationOrEmail(clientDTO.getIdentification(), clientDTO.getEmail())
                .ifPresent(client -> {
                    throw new MiExcepcionPerzonalizada("The client already exists in the application");
                });

        ClientEntity client = ClienteMapper.getClientDtoToClientEntity(clientDTO);

        clientRepository.save(client);

        log.info("Client created successfully");

        iEmailProduce.GenerateTransactionEmail(
                JmsEmailMapper.getUsuarioDTOToEmail(
                        clientDTO.getEmail(),
                        clientDTO.getName(),
                        msEmailConfig.getMessageType(MsEmailConfig.WELCOME),
                        0

                )
        );


        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @Override
    @Cacheable("cacheClient")
    @Transactional(readOnly = true)
    public ResponseEntity listClients() {

        log.debug(
                "listClients() : \n{}"
        );

        return ResponseEntity.ok(clientRepository.findAll());

    }

    @Override
    @Transactional
    @CacheEvict(value = "cacheClient", allEntries = true)
    public ResponseEntity deleteClient(String identification) {

        log.debug("deleteClient() request data: \n{}", identification);

        var client = clientRepository.findByIdentification(identification)
                .orElseThrow(() -> new MiExcepcionPerzonalizada("The customer does not exist in the bank."));

        clientRepository.delete(client);

        return ResponseEntity.ok().build();

    }

    @Override
    @Cacheable("cacheClient")
    @Transactional(readOnly = true)
    public ResponseEntity getClientByIdentification(String identification) {

        var clientOptional = clientRepository.findByIdentification(identification);

        if (!clientOptional.isPresent()) {
            throw new MiExcepcionPerzonalizada("The customer does not exist in the bank.");
        }

        return ResponseEntity.ok(clientOptional.get());
    }

    @Override
    @Transactional
    @CacheEvict(value = "cacheClient", allEntries = true)
    public ResponseEntity modifyClient(String identification, ClientDTO clientDTO) {

        log.debug(
                "actualizarCliente() request data: \n{}",
                identification,
                clientDTO
        );

        var client = clientRepository.findByIdentification(identification).orElseThrow(()->{
            throw new MiExcepcionPerzonalizada("The customer does not exist in the bank.");
        });


        ClientEntity newClient = ClienteMapper.unifyClientDtoToEntity(clientDTO, client);

        clientRepository.save(client);

        return ResponseEntity.ok().build();

    }

}
