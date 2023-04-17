package com.neoris.bank.repository;

import com.neoris.bank.model.TransactionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<TransactionsEntity,Long> {

    @Query("SELECT m FROM TransactionsEntity m WHERE m.account.accountNumber = ?1 ORDER BY m.transactionDate DESC ")
    Optional<List<TransactionsEntity>> findTransaction(String accountNumber);


    @Query("SELECT m FROM TransactionsEntity m WHERE m.account.client.identification = ?1  AND  m.transactionDate BETWEEN ?2 AND ?3 ORDER BY m.transactionDate ASC")
    Optional<List<TransactionsEntity>> findTransactionsByClientAndDates(String identification, LocalDateTime startDate, LocalDateTime endDate);

}
