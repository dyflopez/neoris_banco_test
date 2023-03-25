package com.neoris.bank.service;

import com.neoris.bank.dto.BuscarUsuarioFechaDTO;
import com.neoris.bank.dto.MovimientoDTO;
import com.neoris.bank.model.CuentaEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface IMovimientoService {

    ResponseEntity createMovimientoInicial(MovimientoDTO movimientoDTO , CuentaEntity cuenta);

    ResponseEntity createMovimiento(MovimientoDTO movimientoDTO );

    ResponseEntity reporteMovimientosUsuarioFecha(String identificacion,
                                                  String fechaInicio ,
                                                  String fechaFin);



}
