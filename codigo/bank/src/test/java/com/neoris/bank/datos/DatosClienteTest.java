package com.neoris.bank.datos;

import com.neoris.bank.dto.ClientDTO;

import java.util.Date;
import java.util.List;

public class DatosClienteTest {

    public static ClientDTO clienteDTO (String nombre ,
                                        String identificacion,
                                        String password,
                                        int edad,
                                        String direccion
    ){

        ClientDTO clienteDTO = new ClientDTO();

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

    public static List<ClientDTO> getListClientes(ClientDTO dto){

        List<ClientDTO> clienteDTOList = List.of(dto);

        return clienteDTOList;

    }
}
