package com.neoris.bank.service.impl;

import com.neoris.bank.mappers.ClienteMapper;
import com.neoris.bank.dto.ClienteDTO;
import com.neoris.bank.exception.MiExcepcionPerzonalizada;
import com.neoris.bank.model.ClienteEntity;
import com.neoris.bank.repository.ClienteRepository;
import com.neoris.bank.service.IClienteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class ClienteServiceImpl  implements IClienteService {


    private final ClienteRepository clienteRepository;


    @Override
    public ResponseEntity crearCliente(ClienteDTO clienteDTO) {

        log.debug(
                "crearCliente() request data: \n{}",
                clienteDTO
        );

         var clienteOptional =clienteRepository.findByIdentificacion(clienteDTO.getIdentificacion());

         if (clienteOptional.isPresent()){
             throw new MiExcepcionPerzonalizada("la persona ya existe");
         }


        ClienteEntity cliente= ClienteMapper.getClienteDtoTOClienteEntory(clienteDTO);
        clienteRepository.save(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity listarClientes() {

        log.debug(
                "listarClientes() : \n{}"
        );

        return ResponseEntity.ok(clienteRepository.findAll());

    }

    @Override
    public ResponseEntity eliminarCliente(String identificacion) {

        log.debug(
                "eliminarCliente() request data: \n{}",
                identificacion
        );

        var clienteOptional =clienteRepository.findByIdentificacion(identificacion);

        if (!clienteOptional.isPresent()){
            throw new MiExcepcionPerzonalizada("El usuario no existe");
        }

        clienteRepository.delete(clienteOptional.get());

        return ResponseEntity.ok().build();

    }

    @Override
    public ResponseEntity consultarClienteIdentificacion(String identificacion) {

        var clienteOptional =clienteRepository.findByIdentificacion(identificacion);

        if (!clienteOptional.isPresent()){
            throw new MiExcepcionPerzonalizada("El usuario no existe");
        }

        return ResponseEntity.ok(clienteOptional.get());
    }

    @Override
    public ResponseEntity actualizarCliente(String identificacion, ClienteDTO clienteDTO) {


        log.debug(
                "actualizarCliente() request data: \n{}",
                identificacion,
                clienteDTO
        );

        var clienteOptional =clienteRepository.findByIdentificacion(identificacion);

        if (!clienteOptional.isPresent()){
            throw new MiExcepcionPerzonalizada("El usuario no existe");
        }

        ClienteEntity cliente= ClienteMapper.unificarCLienteDtoToEntity(clienteDTO,clienteOptional.get());

        clienteRepository.save(cliente);


        return ResponseEntity.ok().build();

    }

}
