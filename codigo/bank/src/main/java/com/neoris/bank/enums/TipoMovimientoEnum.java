package com.neoris.bank.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TipoMovimientoEnum {
    RETIRO("retiro","r"), DEPOSITO("deposito","d");

    private String nombre;

    private String abreviatura;



}
