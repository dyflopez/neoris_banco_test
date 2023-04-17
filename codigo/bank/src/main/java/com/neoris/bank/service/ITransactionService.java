package com.neoris.bank.service;

import com.neoris.bank.dto.TransactionDTO;
import com.neoris.bank.model.AccountEntity;
import org.springframework.http.ResponseEntity;

public interface ITransactionService {

    ResponseEntity createInitialTransaction(TransactionDTO transactionDTO,
                                            AccountEntity c);

    ResponseEntity createTransaction(TransactionDTO transactionDTO);

    ResponseEntity getUserTransactionReportByDate(String identification,
                                                  String startDate,
                                                  String endDate);

}
