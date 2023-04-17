package com.neoris.bank.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;


@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchUserDateDTO {

    @NotBlank
    @NotEmpty(message = "La identificacion es un campo requerido")
    private String identification;

    private LocalDateTime startDate;

    private  LocalDateTime endDate;

}
