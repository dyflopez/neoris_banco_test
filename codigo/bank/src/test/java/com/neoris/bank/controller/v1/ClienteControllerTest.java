package com.neoris.bank.controller.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neoris.bank.BankApplication;
import com.neoris.bank.datos.DatosClienteControllerTest;
import com.neoris.bank.datos.DatosClienteEntity;
import com.neoris.bank.datos.DatosClienteTest;
import com.neoris.bank.dto.ClientDTO;
import com.neoris.bank.model.ClientEntity;
import com.neoris.bank.service.IClientService;
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
    IClientService iClienteService;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void createClientTest() throws Exception {

        ClientDTO clienteDTO = DatosClienteTest.clienteDTO("Daniel", "1030", "1122", 30, "19A");
        when(iClienteService.creatClient(any())).thenReturn(DatosClienteControllerTest.crearCliente());

        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clienteDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    void getClientes() throws Exception {

        List<ClientEntity> clienteDTOList = DatosClienteEntity
                .getListClientes(
                        DatosClienteEntity.getClienteEntity("Daniel",
                                "1030",
                                "1122",
                                30,
                                "19A",
                                1l));

        when(iClienteService.listClients()).thenReturn(DatosClienteControllerTest.listarClientes(clienteDTOList));


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

        ClientEntity clienteEntity = DatosClienteEntity
                .getClienteEntity("Daniel",
                        "1030",
                        "1122",
                        30,
                        "19A",
                        1l);

        when(iClienteService.getClientByIdentification(anyString())).thenReturn(DatosClienteControllerTest.getCliente(clienteEntity));

        mvc.perform(get(url + "/1030")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.personaId").value(1))
                .andExpect(jsonPath("$.nombre").value("Daniel"));

    }

    @Test
    void eliminarCliente() throws Exception {

        when(iClienteService.deleteClient(anyString())).thenReturn(DatosClienteControllerTest.getOkTransacction());


        mvc.perform(get(url + "/1030")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void updateCliente() throws Exception {

        ClientDTO clienteDTO = DatosClienteTest.clienteDTO("Daniel", "1030", "1122", 30, "19A");

        when(iClienteService.modifyClient(anyString(),any())).thenReturn(DatosClienteControllerTest.getOkTransacction());


        mvc.perform(get(url + "/1030")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clienteDTO)))
                .andExpect(status().isOk());


    }

}