package com.neoris.bank.service.impl;

import com.neoris.bank.dto.AccountDTO;
import com.neoris.bank.dto.TransactionDTO;
import com.neoris.bank.exception.MiExcepcionPerzonalizada;
import com.neoris.bank.mappers.CuentaMapper;
import com.neoris.bank.mappers.TransactionMapper;
import com.neoris.bank.model.AccountEntity;
import com.neoris.bank.repository.ClientRepository;
import com.neoris.bank.repository.AccountRepository;
import com.neoris.bank.service.IAccountService;
import com.neoris.bank.service.ITransactionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;

    private final ITransactionService iTransactionService;

    @Override
    @Transactional
    @CacheEvict(value = "cacheAccount", allEntries = true)
    public ResponseEntity createAccount(AccountDTO accountDTO) {

        log.debug(
                "createAccount() request data: \n{}",
                accountDTO
        );

        if (accountDTO.getInitialBalance() < 0) {
            throw new MiExcepcionPerzonalizada("The balance cannot be negative");
        }

        TransactionDTO transactionDTO = TransactionMapper.getTransactionsInAccount(accountDTO);

        var client = clientRepository.findByIdentification(accountDTO.getIdentification())
                .orElseThrow(() -> new MiExcepcionPerzonalizada("The client does not exist"));


        accountRepository.findByAccountNumber(accountDTO.getAccountNumber())
                .ifPresent(account -> {
                    throw new MiExcepcionPerzonalizada("The account number already exists");
                });

        AccountEntity account = CuentaMapper.getAccountDtoToAccountEntity(accountDTO, client);
        AccountEntity newAccount = accountRepository.save(account);

        iTransactionService.createInitialTransaction(transactionDTO, newAccount);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }


    @Override
    @Cacheable("cacheAccount")
    @Transactional(readOnly = true)
    public ResponseEntity getAllAccounts() {
        return ResponseEntity.ok(accountRepository.findAll());
    }

    @Override
    @Cacheable("cacheAccount")
    @Transactional(readOnly = true)
    public ResponseEntity getAccountByAccountNumber(String accountNumber) {

        log.debug(
                "consultarCuenta() request data: \n{}",
                accountNumber
        );

        var account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new MiExcepcionPerzonalizada("The bank account does not exist."));

        return ResponseEntity.ok(account);

    }

    @Override
    @Transactional
    @CacheEvict(value = "cacheAccount", allEntries = true)
    public ResponseEntity deleteAccount(String accountNumber) {

        log.debug(
                "deleteAccount() request data: \n{}",
                accountNumber
        );

        var account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new MiExcepcionPerzonalizada("The bank account does not exist."));


        accountRepository.delete(account);

        return ResponseEntity.ok().build();
    }

    @Override
    @Transactional
    @CacheEvict(value = "cacheAccount", allEntries = true)
    public ResponseEntity updateAccount(String accountNumber, AccountDTO accountDTO) {

        log.debug(
                "eliminarCuenta() request data: \n{}",
                accountNumber,
                accountDTO
        );

        var account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new MiExcepcionPerzonalizada("The bank account does not exist"));

        AccountEntity cuenta = CuentaMapper.getCuentaEntity(accountDTO, account);

        accountRepository.save(cuenta);

        return ResponseEntity.ok().build();

    }
}
