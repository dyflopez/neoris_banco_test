package com.neoris.bank.controller.v1;

import com.neoris.bank.controller.v1.docs.ClientDoc;
import com.neoris.bank.dto.ClientDTO;
import com.neoris.bank.service.IClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/client")
public class ClientController implements ClientDoc {


    private  final IClientService iClientService;

    @Override
    @PostMapping
    public ResponseEntity createClient(ClientDTO clientDTO) {
        return iClientService.creatClient(clientDTO);
    }

    @Override
    @GetMapping
    public ResponseEntity getAllClients() {
        return iClientService.listClients();
    }

    @Override
    @GetMapping("/{identification}")
    public ResponseEntity getClientByIdentification(String identification) {
        return iClientService.getClientByIdentification(identification);
    }

    @Override
    @DeleteMapping("/{identification}")
    public ResponseEntity deleteClient(String identification) {
        return iClientService.deleteClient(identification);
    }

    @Override
    @PutMapping("/{identificacion}")
    public ResponseEntity updateClient(String identificacion, ClientDTO userDTO) {
        return iClientService.modifyClient(identificacion,userDTO);
    }


}
