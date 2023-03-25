package com.neoris.bank.datos;

import com.neoris.bank.dto.ClienteDTO;
import com.neoris.bank.model.ClienteEntity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatosClienteTest {

    public static ClienteDTO clienteDTO (String nombre ,
                                         String identificacion,
                                         String password,
                                         int edad,
                                         String direccion
    ){

        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setDireccion(direccion);
        clienteDTO.setNombre(nombre);
        clienteDTO.setGenero("Masculino");
        clienteDTO.setFechaNacimiento(new Date());
        clienteDTO.setEdad(edad);
        clienteDTO.setIdentificacion(identificacion);
        clienteDTO.setTelefono("323");
        clienteDTO.setEstado(true);
        clienteDTO.setPassword(password);

        return clienteDTO;
    }

    public static List<ClienteDTO> getListClientes(ClienteDTO dto){

        List<ClienteDTO> clienteDTOList = List.of(dto);

        return clienteDTOList;

    }
}
