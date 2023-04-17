package com.neoris.bank.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import java.util.Date;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public  class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private  Long personId;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String gender;

    @Column(name = "birthdate")
    private Date birthdate;

    @NotNull
    @NotEmpty
    private String identification;

    @NotNull
    @NotEmpty
    private String address;

    @NotNull
    @NotEmpty
    @Positive
    @Size(min = 8)
    private String phone;

    @NotNull
    @NotEmpty
    @Email
    private  String email;

}
