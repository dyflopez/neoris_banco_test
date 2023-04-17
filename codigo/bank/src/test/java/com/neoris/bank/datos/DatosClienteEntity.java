package com.neoris.bank.datos;

import com.neoris.bank.model.ClientEntity;

import java.util.Date;
import java.util.List;

public class DatosClienteEntity {

    public static ClientEntity getClienteEntity (String nombre ,
                                                 String identificacion,
                                                 String password,
                                                 int edad,
                                                 String direccion,
                                                 long id
    ){

        ClientEntity clienteEntity = new ClientEntity();

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

    public static List<ClientEntity> getListClientes(ClientEntity cliente){

        List<ClientEntity> clienteDTOList = List.of(cliente);

        return clienteDTOList;

    }

}
