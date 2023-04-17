package com.neoris.bank.dto;

import lombok.Setter;
import lombok.Getter;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;


@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    @NotBlank
    @NotEmpty
    private String identification;

    @NotBlank
    @NotEmpty
    private String accountNumber;

    @NotBlank
    @NotEmpty
    private String accountType;

    @Positive
    private Long initialBalance;

    private Boolean status;



}
