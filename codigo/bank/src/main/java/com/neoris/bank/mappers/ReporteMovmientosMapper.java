package com.neoris.bank.mappers;

import com.neoris.bank.constants.Constantes;
import com.neoris.bank.dto.ReporteMovmientosDTO;
import com.neoris.bank.model.MovimientosEntity;
import com.neoris.bank.utils.Utilidades;

import java.util.List;
import java.util.stream.Collectors;

public class ReporteMovmientosMapper {

    public ReporteMovmientosMapper() {
    }

    public static List<ReporteMovmientosDTO> getReportesUsuarioFecha(List<MovimientosEntity> movimientosEntityList) {

        var reporteMovimientoList = movimientosEntityList
                .stream()
                .map(
                        movimento -> ReporteMovmientosDTO
                                .builder()
                                .fecha(
                                        Utilidades.LocalDateTimeToString(movimento.getFecha(),
                                                        Constantes.FORMATO_YYYY_MM_DD_HH_MM_SS)
                                        )
                                .cliente(movimento.getCuenta().getCliente().getNombre())
                                .numeroCuenta(movimento.getCuenta().getNumeroCuenta())
                                .tipo(movimento.getCuenta().getTipoCuenta())
                                .saldoInicial(movimento.getCuenta().getSaldoInicial())
                                .estado(movimento.getCuenta().getEstado())
                                .movimiento(movimento.getValor())
                                .saldoDisponible(movimento.getSaldo())
                                .build()
                )
                .collect(Collectors.toList());

        return reporteMovimientoList;
    }
}
