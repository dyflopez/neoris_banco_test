package com.neoris.bank.datos;

import com.neoris.bank.model.ClienteEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class DatosClienteControllerTest {

    public static ResponseEntity listarClientes(List<ClienteEntity> clienteEntities){
        return ResponseEntity.ok(clienteEntities);
    }

    public static ResponseEntity getCliente(ClienteEntity cliente){
        return ResponseEntity.ok(cliente);
    }

    public static ResponseEntity crearCliente(){
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public static ResponseEntity getOkTransacction(){
        return ResponseEntity.ok().build();
    }



}
