package com.neoris.bank.service.impl;

import com.neoris.bank.dto.BuscarUsuarioFechaDTO;
import com.neoris.bank.dto.MovimientoDTO;
import com.neoris.bank.exception.MiExcepcionPerzonalizada;
import com.neoris.bank.mappers.BuscarMovimientosMapper;
import com.neoris.bank.mappers.MovimientoMapper;
import com.neoris.bank.mappers.ReporteMovmientosMapper;
import com.neoris.bank.model.CuentaEntity;
import com.neoris.bank.model.MovimientosEntity;
import com.neoris.bank.repository.CuentaRepository;
import com.neoris.bank.repository.MovimientosRepository;
import com.neoris.bank.service.IMovimientoService;
import com.neoris.bank.utils.Utilidades;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class MovimientoServiceImpl implements IMovimientoService {

    private final MovimientosRepository movimientosRepository;

    private final CuentaRepository cuentaRepository;


    @Override
    public ResponseEntity createMovimientoInicial(MovimientoDTO movimientoDTO, CuentaEntity cuenta) {

        log.debug(
                "createMovimientoInicial() request data: \n{}",
                movimientoDTO,
                cuenta

        );

        MovimientosEntity movimientosEntity = MovimientoMapper.getMovimientoMapper(movimientoDTO,cuenta,cuenta.getSaldoInicial());


        movimientosRepository.save(movimientosEntity);

        return ResponseEntity.ok().build();

    }

    @Override
    public ResponseEntity createMovimiento(MovimientoDTO movimientoDTO) {

        log.debug(
                "createMovimiento() request data: \n{}",
                movimientoDTO

        );

        var movmientoOp = movimientosRepository.buscarMovimientos(movimientoDTO.getNumeroCuenta());

        if(!movmientoOp.isPresent()){
            throw new MiExcepcionPerzonalizada("la cuenta no existe");
        }

        MovimientosEntity ultimoMovimiento = movmientoOp.get().stream().findFirst().get();

        int total = Utilidades.calcularValorFinal(ultimoMovimiento.getSaldo(),movimientoDTO.getValor());

        if(total<0){
            throw new MiExcepcionPerzonalizada("El saldo no es suficiente");
        }

        var cuentaOp=  cuentaRepository.findByNumeroCuenta(movimientoDTO.getNumeroCuenta());

        MovimientosEntity movimientosEntity = MovimientoMapper.getMovimientoMapper(movimientoDTO,cuentaOp.get(),ultimoMovimiento.getSaldo());

        movimientosRepository.save(movimientosEntity);


        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @Override
    public ResponseEntity reporteMovimientosUsuarioFecha(String identificacion,
                                                         String fechaInicio ,
                                                         String fechaFin) {

        log.debug(
                "reporteMovimientosUsuarioFecha() request data: \n{}",
                identificacion,
                fechaInicio,
                fechaFin

        );

        BuscarUsuarioFechaDTO buscarUsuarioFechaDTO = BuscarMovimientosMapper
                                                        .BuscarMovimientosMapper(
                                                                identificacion,
                                                                fechaInicio,
                                                                fechaFin
                                                        );

        var movimientosOp = movimientosRepository
                                                        .buscarMovimientosUsuarioFechas(
                                                                buscarUsuarioFechaDTO.getIdentificacion(),
                                                                buscarUsuarioFechaDTO.getFechaInicio(),
                                                                buscarUsuarioFechaDTO.getFechaFin()
                                                        );

        if(!movimientosOp.isPresent()){
            throw new MiExcepcionPerzonalizada("no tiene movimientos o usuario no existe");
        }
        var listaMovimientos = ReporteMovmientosMapper.getReportesUsuarioFecha(movimientosOp.get());

        return ResponseEntity.ok(listaMovimientos);

    }
}
