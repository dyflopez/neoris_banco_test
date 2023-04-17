package com.neoris.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@AllArgsConstructor
@Data

@NoArgsConstructor
@Entity
@Table(name = "client")
@PrimaryKeyJoinColumn(name = "client_id", referencedColumnName = "person_id")
public class ClientEntity extends PersonEntity {


    @NotEmpty
    @Size(min = 8)
    private String password;

    private boolean status;



}
