package com.neoris.bank.dto;

import lombok.*;

import javax.persistence.Column;
import java.util.Date;

@Setter
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovimientoDTO {


    private int valor;

    private String numeroCuenta;

}
