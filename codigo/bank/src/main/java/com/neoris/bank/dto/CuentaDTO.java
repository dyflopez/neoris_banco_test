package com.neoris.bank.dto;

import com.neoris.bank.model.ClienteEntity;
import lombok.Setter;
import lombok.Getter;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuentaDTO {

    private String identificacion;

    private String numeroCuenta;

    private String tipoCuenta;

    private Integer saldoInicial;

    private Boolean estado;



}
