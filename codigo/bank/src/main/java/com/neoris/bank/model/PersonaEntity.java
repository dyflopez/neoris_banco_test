package com.neoris.bank.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
public  class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "persona_id")
    private  Long personaId;

    private String nombre;

    private String genero;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    private int edad;

    private String identificacion;

    private String direccion;

    private String telefono;

}
