package com.neoris.bank.service.impl;

import com.neoris.bank.dto.SearchUserDateDTO;
import com.neoris.bank.dto.TransactionDTO;
import com.neoris.bank.exception.MiExcepcionPerzonalizada;
import com.neoris.bank.mappers.SearchTransactionsMapper;
import com.neoris.bank.mappers.TransactionMapper;
import com.neoris.bank.mappers.ReporteMovmientosMapper;
import com.neoris.bank.model.AccountEntity;
import com.neoris.bank.model.TransactionsEntity;
import com.neoris.bank.repository.AccountRepository;
import com.neoris.bank.repository.TransactionRepository;
import com.neoris.bank.service.ITransactionService;
import com.neoris.bank.utils.Utilities;
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
public class TransactionServiceImpl implements ITransactionService {

    private final TransactionRepository transactionRepository;

    private final AccountRepository accountRepository;


    @Override
    @Transactional
    @CacheEvict(value = "cacheTransactions", allEntries = true)
    public ResponseEntity createInitialTransaction(TransactionDTO transactionDTO, AccountEntity account) {

        log.debug(
                "createMovimientoInicial() request data: \n{}",
                transactionDTO,
                account

        );

        TransactionsEntity transactionsEntity = TransactionMapper.getTransactionMapper(transactionDTO, account, account.getInitialBalance());


        transactionRepository.save(transactionsEntity);

        return ResponseEntity.ok().build();

    }

    @Override
    @Transactional
    @CacheEvict(value = "cacheTransactions", allEntries = true)
    public ResponseEntity createTransaction(TransactionDTO transactionDTO) {

        log.debug("createTransaction() request data: \n{}", transactionDTO);

        TransactionsEntity lastTransaction = transactionRepository
                .findTransaction(transactionDTO.getAccountNumber())
                .orElseThrow(
                        () -> new MiExcepcionPerzonalizada("The account does not exist.")
                )
                .stream().findFirst().get();


        long total = Utilities.calculateFinalValue(lastTransaction.getBalance(), transactionDTO.getAmount());


        if (total < 0) {
            throw new MiExcepcionPerzonalizada("The balance is not sufficient.");
        }

        AccountEntity cuentaOp = accountRepository.findByAccountNumber(transactionDTO.getAccountNumber()).get();


        TransactionsEntity transactionsEntity = TransactionMapper.getTransactionMapper(transactionDTO, cuentaOp, lastTransaction.getBalance());

        transactionRepository.save(transactionsEntity);


        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @Override
    @Cacheable("cacheTransactions")
    @Transactional(readOnly = true)
    public ResponseEntity getUserTransactionReportByDate(String identification,
                                                         String startDate,
                                                         String endDate) {

        log.debug("getUserTransactionReportByDate() request data: \n{}", identification, startDate, endDate);

        SearchUserDateDTO userDateDTO = SearchTransactionsMapper.getTransactionDatesMapper(identification, startDate, endDate);

        var transactions = transactionRepository
                .findTransactionsByClientAndDates(
                        userDateDTO.getIdentification(),
                        userDateDTO.getStartDate(),
                        userDateDTO.getEndDate()
                );

        if (!transactions.isPresent()) {
            throw new MiExcepcionPerzonalizada("You do not have any transactions or the user does not exist");
        }

        var listaMovimientos = ReporteMovmientosMapper.getReportesUsuarioFecha(transactions.get());

        return ResponseEntity.ok(listaMovimientos);

    }
}
