package com.neoris.bank.service;

import com.neoris.bank.dto.ClientDTO;
import org.springframework.http.ResponseEntity;

public interface IClientService {

    ResponseEntity creatClient(ClientDTO clientDTO);

    ResponseEntity listClients();

    public ResponseEntity deleteClient(String identification);


    public ResponseEntity getClientByIdentification(String identification);

    public ResponseEntity modifyClient(String identification, ClientDTO clientDTO) ;

}
