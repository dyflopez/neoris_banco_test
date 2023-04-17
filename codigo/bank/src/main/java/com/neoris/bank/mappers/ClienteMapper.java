package com.neoris.bank.mappers;


import com.neoris.bank.dto.ClientDTO;
import com.neoris.bank.model.ClientEntity;

public class ClienteMapper {

    private ClienteMapper() {
    }

    public static ClientEntity getClientDtoToClientEntity(ClientDTO clientDTO) {


        ClientEntity client = new ClientEntity();
        client.setAddress(clientDTO.getAddress());
        client.setName(clientDTO.getName());
        client.setGender(clientDTO.getGender());
        client.setBirthdate(clientDTO.getBirthdate());
        client.setIdentification(clientDTO.getIdentification());
        client.setPhone(clientDTO.getPhone());
        client.setStatus(clientDTO.isStatus());
        client.setEmail(clientDTO.getEmail());
        client.setPassword(clientDTO.getPassword());

        return client;

    }

    public static ClientEntity unifyClientDtoToEntity(ClientDTO clientDTO, ClientEntity client) {

        client.setAddress(clientDTO.getAddress());
        client.setName(clientDTO.getName());
        client.setGender(clientDTO.getGender());
        client.setBirthdate(clientDTO.getBirthdate());
        client.setIdentification(clientDTO.getIdentification());
        client.setPhone(clientDTO.getPhone());
        client.setStatus(clientDTO.isStatus());
        client.setPassword(clientDTO.getPassword());

        return client;

    }



}
