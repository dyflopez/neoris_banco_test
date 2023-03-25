package com.neoris.bank.service;

import com.neoris.bank.dto.ClienteDTO;
import org.springframework.http.ResponseEntity;

public interface IClienteService {

    ResponseEntity crearCliente(ClienteDTO clienteDTO);

    ResponseEntity listarClientes();

    ResponseEntity eliminarCliente(String identificacion);


    ResponseEntity consultarClienteIdentificacion(String  identificacion);

    ResponseEntity actualizarCliente(String  identificacion,ClienteDTO clienteDTO);

}
