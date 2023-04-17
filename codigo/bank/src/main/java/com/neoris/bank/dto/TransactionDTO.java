package com.neoris.bank.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {


    @NotBlank
    @NotEmpty
    @Min(50)
    private Long amount;

    @NotBlank
    @NotEmpty
    private String accountNumber;

}
