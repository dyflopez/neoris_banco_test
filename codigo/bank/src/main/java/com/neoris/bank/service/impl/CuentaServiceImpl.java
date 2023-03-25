package com.neoris.bank.service.impl;

import com.neoris.bank.dto.CuentaDTO;
import com.neoris.bank.dto.MovimientoDTO;
import com.neoris.bank.exception.MiExcepcionPerzonalizada;
import com.neoris.bank.mappers.CuentaMapper;
import com.neoris.bank.model.CuentaEntity;
import com.neoris.bank.repository.ClienteRepository;
import com.neoris.bank.repository.CuentaRepository;
import com.neoris.bank.service.ICuentaService;
import com.neoris.bank.service.IMovimientoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class CuentaServiceImpl implements ICuentaService {

    private final CuentaRepository cuentaRepository;
    private final ClienteRepository clienteRepository;

    private final IMovimientoService iMovimientoService;

    @Override
    public ResponseEntity crearCuenta(CuentaDTO cuentaDTO) {


        if (cuentaDTO.getSaldoInicial()<0) {
            throw new MiExcepcionPerzonalizada("El saldo no puede ser negativo");
        }

        MovimientoDTO movimientoDTO = MovimientoDTO
                                        .builder()
                                        .numeroCuenta(cuentaDTO.getNumeroCuenta())
                                        .valor(cuentaDTO.getSaldoInicial())
                                        .build();

        var clienteOptional = clienteRepository.findByIdentificacion(cuentaDTO.getIdentificacion());



        if (!clienteOptional.isPresent()) {
            throw new MiExcepcionPerzonalizada("el cliente no existe");
        }

        var cuentaOp = cuentaRepository.findByNumeroCuenta(cuentaDTO.getNumeroCuenta());

        if (cuentaOp.isPresent()) {
            throw new MiExcepcionPerzonalizada("la cuenta ya existe");
        }

        CuentaEntity cuenta = CuentaMapper.getCuentaDtoToCuentaEntiry(cuentaDTO, clienteOptional.get());

        var nuevaCuenta=cuentaRepository.save(cuenta);


        iMovimientoService.createMovimientoInicial(movimientoDTO,nuevaCuenta);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @Override
    public ResponseEntity listarCuentas() {

        return ResponseEntity.ok(cuentaRepository.findAll());


    }

    @Override
    public ResponseEntity consultarCuenta(String numeroCuenta) {

        log.debug(
                "consultarCuenta() request data: \n{}",
                numeroCuenta
        );

        var cuenta = cuentaRepository.findByNumeroCuenta(numeroCuenta);

        return ResponseEntity.ok(cuenta.get());

    }

    @Override
    public ResponseEntity eliminarCuenta(String numeroCuenta) {

        log.debug(
                "eliminarCuenta() request data: \n{}",
                numeroCuenta
        );

        var cuenta = cuentaRepository.findByNumeroCuenta(numeroCuenta);
        if (!cuenta.isPresent()) {
            throw new MiExcepcionPerzonalizada("la cuenta no existe");
        }
        cuentaRepository.delete(cuenta.get());

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity actualizarCuenta(String numeroCuenta, CuentaDTO cuentaDTO) {

        log.debug(
                "eliminarCuenta() request data: \n{}",
                numeroCuenta,
                cuentaDTO
        );

        var cuentaOp = cuentaRepository.findByNumeroCuenta(numeroCuenta);
        if (!cuentaOp.isPresent()) {
            throw new MiExcepcionPerzonalizada("la cuenta no existe");
        }

        CuentaEntity cuenta = CuentaMapper.getCuentaEntity(cuentaDTO, cuentaOp.get());

        cuentaRepository.save(cuenta);

        return ResponseEntity.ok().build();

    }
}
