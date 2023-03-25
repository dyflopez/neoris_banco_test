package com.neoris.bank.controller.v1;

import com.neoris.bank.controller.v1.docs.CuentaDoc;
import com.neoris.bank.dto.CuentaDTO;
import com.neoris.bank.service.ICuentaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/cuenta")
public class CuentaController implements CuentaDoc {

    private final ICuentaService iCuentaService;

    @Override
    @PostMapping
    public ResponseEntity createCuenta(CuentaDTO cuentaDTO) {

        return iCuentaService.crearCuenta(cuentaDTO);

    }

    @Override
    @GetMapping
    public ResponseEntity getCuentas() {
        return iCuentaService.listarCuentas();
    }

    @Override
    @GetMapping("/{numeroCuenta}")
    public ResponseEntity consultarCuenta(String numeroCuenta) {
        return iCuentaService.consultarCuenta(numeroCuenta);
    }

    @Override
    @DeleteMapping("/{numeroCuenta}")
    public ResponseEntity eliminarCuenta(String numeroCuenta) {
        return iCuentaService.eliminarCuenta(numeroCuenta);
    }

    @Override
    @PutMapping("/{numeroCuenta}")
    public ResponseEntity updateCliente(String numeroCuenta, CuentaDTO cuentaDTO) {
        return iCuentaService.actualizarCuenta(numeroCuenta,cuentaDTO);
    }

}
