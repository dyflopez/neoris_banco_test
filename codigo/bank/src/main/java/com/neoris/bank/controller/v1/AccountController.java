package com.neoris.bank.controller.v1;

import com.neoris.bank.controller.v1.docs.AccountDoc;
import com.neoris.bank.dto.AccountDTO;
import com.neoris.bank.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController implements AccountDoc {

    private final IAccountService iAccountService;

    @Override
    @PostMapping
    public ResponseEntity createAccount(AccountDTO accountDTO) {

        return iAccountService.createAccount(accountDTO);

    }

    @Override
    @GetMapping
    public ResponseEntity getAllAccounts() {
        return iAccountService.getAllAccounts();
    }

    @Override
    @GetMapping("/{accountNumber}")
    public ResponseEntity getAccountByAccountNumber(String accountNumber) {
        return iAccountService.getAccountByAccountNumber(accountNumber);
    }

    @Override
    @DeleteMapping("/{accountNumber}")
    public ResponseEntity deleteAccount(String accountNumber) {
        return iAccountService.deleteAccount(accountNumber);
    }

    @Override
    @PutMapping("/{accountNumber}")
    public ResponseEntity updateAccountByAccountNumber(String accountNumber, AccountDTO accountDTO) {
        return iAccountService.updateAccount(accountNumber, accountDTO);
    }

}