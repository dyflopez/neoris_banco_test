package com.neoris.bank.dto;


import lombok.*;


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

    private int saldoInicial;

    private boolean estado;

    private int movimiento;

    private int saldoDisponible;

}
