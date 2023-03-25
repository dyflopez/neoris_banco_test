package com.neoris.bank.mappers;

import com.neoris.bank.dto.MovimientoDTO;
import com.neoris.bank.model.CuentaEntity;
import com.neoris.bank.model.MovimientosEntity;
import com.neoris.bank.utils.Utilidades;

import java.time.LocalDateTime;

public class MovimientoMapper {

    public MovimientoMapper(){

    }

    public static MovimientosEntity getMovimientoMapper(MovimientoDTO movimientoDTO ,
                                                        CuentaEntity cuentaEntity,
                                                        int saldo){

        return MovimientosEntity
                .builder()
                .fecha( LocalDateTime.now())
                .cuenta(cuentaEntity)
                .tipoMovimiento(Utilidades.getTipoMOvimiento(movimientoDTO.getValor()))
                .valor(movimientoDTO.getValor())
                .saldo(saldo)
                .build() ;

    }


}
