package com.neoris.bank.utils;

import com.neoris.bank.constants.Constantes;
import com.neoris.bank.enums.TipoMovimientoEnum;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utilidades {

    public static String getTipoMOvimiento(int valorTransaccion) {

        return valorTransaccion < 0 ? TipoMovimientoEnum.RETIRO.getNombre() : TipoMovimientoEnum.DEPOSITO.getNombre();

    }

    public static int calcularValorFinal(int valorInicial, int valorTransaccion) {

//        String tipoMovimiento =getTipoMOvimiento(valorInicial);

        int total;

        // if(tipoMovimiento.equalsIgnoreCase(TipoMovimientoEnum.RETIRO.getNombre())){
        total = valorInicial + valorTransaccion;
        //}


        return total;
    }

    public static LocalDateTime stringToLocalDateTime(String fecha, String formato) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        LocalDateTime fechaLocalDateTime = LocalDateTime.parse(fecha, formatter);

        return fechaLocalDateTime;
    }

    public static String LocalDateTimeToString(LocalDateTime fecha, String formato) {

        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern(formato);
        String fechaStr = fecha.format(formatoFecha);

        return fechaStr;
    }


}
