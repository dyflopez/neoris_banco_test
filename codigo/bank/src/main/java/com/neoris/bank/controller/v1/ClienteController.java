package com.neoris.bank.controller.v1;

import com.neoris.bank.controller.v1.docs.ClienteDoc;
import com.neoris.bank.dto.ClienteDTO;
import com.neoris.bank.service.IClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/cliente")
public class ClienteController implements ClienteDoc {


    private  final IClienteService iClienteService;

    @Override
    @PostMapping
    public ResponseEntity createUSer(ClienteDTO clienteDTO) {
        return iClienteService.crearCliente(clienteDTO);
    }

    @Override
    @GetMapping
    public ResponseEntity getClientes() {
        return iClienteService.listarClientes();
    }

    @Override
    @GetMapping("/{identificacion}")
    public ResponseEntity consultarUsuario(String identificacion) {
        return iClienteService.consultarClienteIdentificacion(identificacion);
    }

    @Override
    @DeleteMapping("/{identificacion}")
    public ResponseEntity eliminarCliente(String identificacion) {
        return iClienteService.eliminarCliente(identificacion);
    }

    @Override
    @PutMapping("/{identificacion}")
    public ResponseEntity updateCliente(String identificacion, ClienteDTO userDTO) {
        return iClienteService.actualizarCliente(identificacion,userDTO);
    }


}
