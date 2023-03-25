package com.neoris.bank.mappers;


import com.neoris.bank.dto.ClienteDTO;
import com.neoris.bank.model.ClienteEntity;
import com.neoris.bank.model.PersonaEntity;

public class ClienteMapper {

    private ClienteMapper() {
    }

    public static ClienteEntity getClienteDtoTOClienteEntory(ClienteDTO clienteDTO) {


        ClienteEntity cliente = new ClienteEntity();
        cliente.setDireccion(clienteDTO.getDireccion());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setGenero(clienteDTO.getGenero());
        cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());
        cliente.setEdad(clienteDTO.getEdad());
        cliente.setIdentificacion(clienteDTO.getIdentificacion());
        cliente.setTelefono(clienteDTO.getDireccion());
        cliente.setEstado(clienteDTO.isEstado());
        cliente.setPassword(clienteDTO.getPassword());

        return cliente;

    }

    public static ClienteEntity unificarCLienteDtoToEntity(ClienteDTO clienteDTO,ClienteEntity cliente) {

        cliente.setDireccion(clienteDTO.getDireccion());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setGenero(clienteDTO.getGenero());
        cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());
        cliente.setEdad(clienteDTO.getEdad());
        cliente.setIdentificacion(clienteDTO.getIdentificacion());
        cliente.setTelefono(clienteDTO.getDireccion());
        cliente.setEstado(clienteDTO.isEstado());
        cliente.setPassword(clienteDTO.getPassword());

        return cliente;

    }



}
