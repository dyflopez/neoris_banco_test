package com.neoris.bank.dto;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Setter
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReporteMovmientosDTO {

    private String fecha;

    private String cliente;

    private String numeroCuenta;

    private String tipo;

    private long saldoInicial;

    private boolean estado;

    private long movimiento;

    private long saldoDisponible;

}
