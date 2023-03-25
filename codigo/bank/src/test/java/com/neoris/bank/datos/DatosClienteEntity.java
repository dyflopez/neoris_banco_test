package com.neoris.bank.datos;

import com.neoris.bank.dto.ClienteDTO;
import com.neoris.bank.model.ClienteEntity;

import javax.swing.text.html.parser.Entity;
import java.util.Date;
import java.util.List;

public class DatosClienteEntity {

    public static ClienteEntity getClienteEntity (String nombre ,
                                         String identificacion,
                                         String password,
                                         int edad,
                                         String direccion,
                                                  long id
    ){

        ClienteEntity clienteEntity = new ClienteEntity();

        clienteEntity.setPersonaId(id);
        clienteEntity.setDireccion(direccion);
        clienteEntity.setNombre(nombre);
        clienteEntity.setGenero("Masculino");
        clienteEntity.setFechaNacimiento(new Date());
        clienteEntity.setEdad(edad);
        clienteEntity.setIdentificacion(identificacion);
        clienteEntity.setTelefono("323");
        clienteEntity.setEstado(true);
        clienteEntity.setPassword(password);

        return clienteEntity;
    }

    public static List<ClienteEntity> getListClientes(ClienteEntity cliente){

        List<ClienteEntity> clienteDTOList = List.of(cliente);

        return clienteDTOList;

    }

}
