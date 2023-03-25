package com.neoris.bank.controller.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neoris.bank.BankApplication;
import com.neoris.bank.datos.DatosClienteControllerTest;
import com.neoris.bank.datos.DatosClienteEntity;
import com.neoris.bank.datos.DatosClienteTest;
import com.neoris.bank.dto.ClienteDTO;
import com.neoris.bank.model.ClienteEntity;
import com.neoris.bank.service.IClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = BankApplication.class)
@AutoConfigureMockMvc
class ClienteControllerTest {

    private String url = "/cliente";

    @Autowired
    private MockMvc mvc;

    @MockBean
    IClienteService iClienteService;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void createUSer() throws Exception {

        ClienteDTO clienteDTO = DatosClienteTest.clienteDTO("Daniel", "1030", "1122", 30, "19A");
        when(iClienteService.crearCliente(any())).thenReturn(DatosClienteControllerTest.crearCliente());

        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clienteDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    void getClientes() throws Exception {

        List<ClienteEntity> clienteDTOList = DatosClienteEntity
                .getListClientes(
                        DatosClienteEntity.getClienteEntity("Daniel",
                                "1030",
                                "1122",
                                30,
                                "19A",
                                1l));

        when(iClienteService.listarClientes()).thenReturn(DatosClienteControllerTest.listarClientes(clienteDTOList));


        mvc.perform(get(url)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].personaId").value(1))
                .andExpect(jsonPath("$[0].nombre").value("Daniel"))
        ;
    }

    @Test
    void consultarUsuario() throws Exception {

        ClienteEntity clienteEntity = DatosClienteEntity
                .getClienteEntity("Daniel",
                        "1030",
                        "1122",
                        30,
                        "19A",
                        1l);

        when(iClienteService.consultarClienteIdentificacion(anyString())).thenReturn(DatosClienteControllerTest.getCliente(clienteEntity));

        mvc.perform(get(url + "/1030")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.personaId").value(1))
                .andExpect(jsonPath("$.nombre").value("Daniel"));

    }

    @Test
    void eliminarCliente() throws Exception {

        when(iClienteService.eliminarCliente(anyString())).thenReturn(DatosClienteControllerTest.getOkTransacction());


        mvc.perform(get(url + "/1030")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void updateCliente() throws Exception {

        ClienteDTO clienteDTO = DatosClienteTest.clienteDTO("Daniel", "1030", "1122", 30, "19A");

        when(iClienteService.actualizarCliente(anyString(),any())).thenReturn(DatosClienteControllerTest.getOkTransacction());


        mvc.perform(get(url + "/1030")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clienteDTO)))
                .andExpect(status().isOk());


    }

}