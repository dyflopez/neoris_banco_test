package com.neoris.bank.mappers;

import com.neoris.bank.constants.Constantes;
import com.neoris.bank.dto.BuscarUsuarioFechaDTO;
import com.neoris.bank.utils.Utilidades;

public class BuscarMovimientosMapper {

    public BuscarMovimientosMapper(){}

    public static  BuscarUsuarioFechaDTO BuscarMovimientosMapper(String identificacion,
                                   String fechaInicio,
                                   String fechaFin){
        return BuscarUsuarioFechaDTO
                .builder()
                .identificacion(identificacion)
                .fechaInicio(Utilidades.stringToLocalDateTime(fechaInicio, Constantes.FORMATO_YYYY_MM_DD_HH_MM_SS))
                .fechaFin(Utilidades.stringToLocalDateTime(fechaFin, Constantes.FORMATO_YYYY_MM_DD_HH_MM_SS))
                .build();
    }
}
