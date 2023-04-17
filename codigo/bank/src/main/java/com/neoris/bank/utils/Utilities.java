package com.neoris.bank.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neoris.bank.enums.TipoMovimientoEnum;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class Utilities {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String getTypeTransaction(long amountTransaction) {

        return amountTransaction < 0 ? TipoMovimientoEnum.RETIRO.getNombre() : TipoMovimientoEnum.DEPOSITO.getNombre();

    }

    public static long calculateFinalValue(long initialBalnce, long amountTransaction) {

        return initialBalnce + amountTransaction;
    }

    public static LocalDateTime stringToLocalDateTime(String date, String formatDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatDate);
        return LocalDateTime.parse(date, formatter);
    }

    public static String LocalDateTimeToString(LocalDateTime date, String formatDate) {

        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern(formatDate);

        return date.format(formatoFecha);
    }

    public static String convertToJson(@NotNull final Object data) {
        try {
            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }

}
