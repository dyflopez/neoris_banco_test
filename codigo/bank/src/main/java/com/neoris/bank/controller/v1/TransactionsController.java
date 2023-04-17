package com.neoris.bank.controller.v1;

import com.neoris.bank.controller.v1.docs.TransactionsDoc;
import com.neoris.bank.dto.TransactionDTO;
import com.neoris.bank.service.ITransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/transaction")
public class TransactionsController implements TransactionsDoc {


    private final ITransactionService iTransactionService;

    @Override
    @PostMapping
    public ResponseEntity createTransactions(TransactionDTO transactionDTO) {
        return iTransactionService.createTransaction(transactionDTO);
    }

    @Override
    @GetMapping("/report")
    public ResponseEntity getTransactionByIdentification(String identification,
                                          String startDate ,
                                          String endDate
    ) {
        return iTransactionService.getUserTransactionReportByDate(identification,startDate,endDate);
    }


}
