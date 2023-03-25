package com.neoris.bank.dto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {

    private String nombre;

    private String genero;

    private Date fechaNacimiento;

    private int edad;

    private String identificacion;

    private String direccion;

    private String telefono;

}
