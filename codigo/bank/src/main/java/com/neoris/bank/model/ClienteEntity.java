package com.neoris.bank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



//@Builder
@AllArgsConstructor
@Data

@NoArgsConstructor
@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "cliente_id", referencedColumnName = "persona_id")
public class ClienteEntity extends PersonaEntity{



    private String password;

    private boolean estado;



}
