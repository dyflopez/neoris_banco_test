package com.neoris.bank.mappers;

import com.neoris.bank.constants.Constantes;
import com.neoris.bank.dto.ReporteMovmientosDTO;
import com.neoris.bank.model.TransactionsEntity;
import com.neoris.bank.utils.Utilities;

import java.util.List;
import java.util.stream.Collectors;

public class ReporteMovmientosMapper {

    public ReporteMovmientosMapper() {
    }

    public static List<ReporteMovmientosDTO> getReportesUsuarioFecha(List<TransactionsEntity> movimientosEntityList) {

        var reporteMovimientoList = movimientosEntityList
                .stream()
                .map(
                        movimento -> ReporteMovmientosDTO
                                .builder()
                                .fecha(
                                        Utilities.LocalDateTimeToString(movimento.getTransactionDate(),
                                                        Constantes.FORMATO_YYYY_MM_DD_HH_MM_SS)
                                        )
                                .cliente(movimento.getAccount().getClient().getName())
                                .numeroCuenta(movimento.getAccount().getAccountNumber())
                                .tipo(movimento.getAccount().getAccountType())
                                .saldoInicial(movimento.getAccount().getInitialBalance())
                                .estado(movimento.getAccount().getStatus())
                                .movimiento(movimento.getAmount())
                                .saldoDisponible(movimento.getBalance())
                                .build()
                )
                .collect(Collectors.toList());

        return reporteMovimientoList;
    }
}
