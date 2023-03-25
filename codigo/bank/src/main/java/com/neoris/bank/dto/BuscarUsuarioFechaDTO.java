package com.neoris.bank.dto;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuscarUsuarioFechaDTO {

    private String identificacion;

    private LocalDateTime fechaInicio;

    private  LocalDateTime fechaFin;

}
