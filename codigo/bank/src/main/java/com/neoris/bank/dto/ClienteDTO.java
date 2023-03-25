package com.neoris.bank.dto;

import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO extends PersonaDTO{

    private String password;

    private boolean estado;

}
