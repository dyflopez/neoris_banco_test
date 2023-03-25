package com.neoris.bank.service;

import com.neoris.bank.dto.CuentaDTO;
import org.springframework.http.ResponseEntity;

public interface ICuentaService {

    ResponseEntity crearCuenta(CuentaDTO cuentaDTO);

    ResponseEntity listarCuentas();

    ResponseEntity consultarCuenta(String numeroCuenta);

    ResponseEntity eliminarCuenta(String numeroCuenta);

    ResponseEntity actualizarCuenta(String numeroCuenta, CuentaDTO cuentaDTO);
}
