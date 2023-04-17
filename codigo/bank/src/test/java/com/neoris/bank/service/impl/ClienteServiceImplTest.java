package com.neoris.bank.service.impl;

import com.neoris.bank.configs.ExceptionConfigs;
import com.neoris.bank.datos.DatosClienteEntity;
import com.neoris.bank.datos.DatosClienteTest;
import com.neoris.bank.dto.ClientDTO;
import com.neoris.bank.exception.MiExcepcionPerzonalizada;
import com.neoris.bank.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;



import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
class ClienteServiceImplTest {

    @Autowired
    ClientServiceImpl clienteService;

    @MockBean
    ClientRepository clienteRepository;

    @MockBean
    ExceptionConfigs exceptionConfigs;

    @Test
    void crearClienteOk() {
        var clienteEntiry = DatosClienteEntity
                .getClienteEntity("Daniel",
                        "1030",
                        "1122",
                        30,
                        "19A",
                        1l);

        ClientDTO clienteDTO = DatosClienteTest
                .clienteDTO("Daniel",
                        "1030",
                        "1122",
                        30,
                        "19A"
                );

        when(clienteRepository.save(any())).thenReturn(clienteEntiry);
        when(clienteRepository.findByIdentification(anyString())).thenReturn(Optional.empty());

        ResponseEntity response =   clienteService.creatClient(clienteDTO);
        verify(clienteRepository, times(1)).save(any());
        verify(clienteRepository, times(1)).findByIdentification(any());
        assertEquals(201,response.getStatusCode().value());

    }
    @Test
    void crearClienteError() {
        var clienteEntiry = DatosClienteEntity
                .getClienteEntity("Daniel",
                        "1030",
                        "1122",
                        30,
                        "19A",
                        1l);

        ClientDTO clienteDTO = DatosClienteTest
                .clienteDTO("Daniel",
                        "1030",
                        "1122",
                        30,
                        "19A"
                );

        when(clienteRepository.findByIdentification(anyString())).thenReturn(Optional.of(clienteEntiry));


        Exception exception =assertThrows(MiExcepcionPerzonalizada.class,()->{
            clienteService.creatClient(clienteDTO);
        });

        assertNotNull(exception);
        assertEquals(exception.getMessage(),"la persona ya existe");
        verify(clienteRepository, times(1)).findByIdentification(any());

    }

}