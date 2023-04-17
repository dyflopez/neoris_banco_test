package com.neoris.bank.mappers;

import com.neoris.bank.dto.AccountDTO;
import com.neoris.bank.dto.TransactionDTO;
import com.neoris.bank.model.AccountEntity;
import com.neoris.bank.model.TransactionsEntity;
import com.neoris.bank.utils.Utilities;

import java.time.LocalDateTime;

public class TransactionMapper {

    public TransactionMapper(){

    }

    public static TransactionsEntity getTransactionMapper(TransactionDTO transactionDTO ,
                                                         AccountEntity account,
                                                         long balance){

        return TransactionsEntity
                .builder()
                .transactionDate( LocalDateTime.now())
                .account(account)
                .transactionType(Utilities.getTypeTransaction(transactionDTO.getAmount()))
                .amount(transactionDTO.getAmount())
                .balance(balance)
                .build() ;

    }

    public static  TransactionDTO getTransactionsInAccount(AccountDTO accountDTO){

        return TransactionDTO
                .builder()
                .accountNumber(accountDTO.getAccountNumber())
                .amount(accountDTO.getInitialBalance())
                .build();

    }


}
