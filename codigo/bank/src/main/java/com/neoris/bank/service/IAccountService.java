package com.neoris.bank.service;

import com.neoris.bank.dto.AccountDTO;
import org.springframework.http.ResponseEntity;

public interface IAccountService {

    ResponseEntity createAccount(AccountDTO accountDTO);

    ResponseEntity getAllAccounts();

    ResponseEntity getAccountByAccountNumber(String accountNumber);

    ResponseEntity deleteAccount(String accountNumber);

    ResponseEntity updateAccount(String accountNumber, AccountDTO accountDTO);
}
