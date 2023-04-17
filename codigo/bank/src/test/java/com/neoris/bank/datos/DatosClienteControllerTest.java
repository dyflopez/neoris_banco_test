package com.neoris.bank.datos;

import com.neoris.bank.model.ClientEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class DatosClienteControllerTest {

    public static ResponseEntity listarClientes(List<ClientEntity> clienteEntities){
        return ResponseEntity.ok(clienteEntities);
    }

    public static ResponseEntity getCliente(ClientEntity cliente){
        return ResponseEntity.ok(cliente);
    }

    public static ResponseEntity crearCliente(){
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public static ResponseEntity getOkTransacction(){
        return ResponseEntity.ok().build();
    }



}
