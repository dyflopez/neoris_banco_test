package com.neoris.bank.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO extends PersonaDTO{

    @NotBlank
    @NotEmpty
    @Size(min = 8)
    private String password;

    private boolean status;

}
