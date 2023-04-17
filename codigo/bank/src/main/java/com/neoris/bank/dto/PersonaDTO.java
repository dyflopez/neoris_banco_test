package com.neoris.bank.dto;

import lombok.Setter;
import lombok.Getter;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.Date;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {


    @NotBlank
    @NotEmpty(message = "El nombre no puede estar vacio")
    private String name;

    @NotBlank
    @NotEmpty(message = "Genero vacio")
    private String gender;


    private Date birthdate;

    @NotEmpty
    private String identification;

    @NotEmpty
    private String address;

    @Min(7)
    @NotEmpty
    private String phone;

    @NotNull
    @NotEmpty
    @Email
    private  String email;

}
