package com.neoris.bank.controller.v1;

import com.neoris.bank.controller.v1.docs.MovmientosDoc;
import com.neoris.bank.dto.BuscarUsuarioFechaDTO;
import com.neoris.bank.dto.MovimientoDTO;
import com.neoris.bank.service.IMovimientoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@RestController
@RequestMapping("/movmiento")
public class MovimientoController implements MovmientosDoc {


    private final IMovimientoService movimientoService;

    @Override
    @PostMapping
    public ResponseEntity createMovimiento(MovimientoDTO movimientoDTO) {
        return movimientoService.createMovimiento(movimientoDTO);
    }

    @Override
    @GetMapping("/reportes")
    public ResponseEntity consultarCuenta(String identificacion,
                                          String fechaInicio ,
                                          String fechaFin
    ) {
        return movimientoService.reporteMovimientosUsuarioFecha(identificacion,fechaInicio,fechaFin);
    }


}
