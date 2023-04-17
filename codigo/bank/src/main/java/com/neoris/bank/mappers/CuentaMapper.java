package com.neoris.bank.mappers;

import com.neoris.bank.dto.AccountDTO;
import com.neoris.bank.model.ClientEntity;
import com.neoris.bank.model.AccountEntity;

public class CuentaMapper {

    private CuentaMapper (){
    }

    public static AccountEntity getAccountDtoToAccountEntity(AccountDTO accountDTO, ClientEntity clientEntity) {

        return  AccountEntity
                .builder()
                .accountNumber(accountDTO.getAccountNumber())
                .accountType(accountDTO.getAccountType())
                .initialBalance(accountDTO.getInitialBalance())
                .status(accountDTO.getStatus())
                .client(clientEntity)
                .build();

    }

    public static AccountEntity getCuentaEntity(AccountDTO cuentaDTO, AccountEntity clienteEntity) {

        return  clienteEntity
                .builder()
                .accountNumber(cuentaDTO.getAccountNumber())
                .accountType(cuentaDTO.getAccountType())
                .initialBalance(cuentaDTO.getInitialBalance())
                .status(cuentaDTO.getStatus())
                .client(clienteEntity.getClient())
                .build();

    }
}
