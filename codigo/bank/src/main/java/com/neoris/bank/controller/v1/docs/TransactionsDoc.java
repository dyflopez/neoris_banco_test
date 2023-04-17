package com.neoris.bank.controller.v1.docs;

import com.neoris.bank.dto.TransactionDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Tag(name = "transactions", description = "Operations related to transactions of Account")
public interface TransactionsDoc {

    @Operation(summary = "create a banking transaction",
            description = "This operation is used to create a banking transaction")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transaction created",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    ResponseEntity createTransactions(
            @Valid @RequestBody TransactionDTO transactionDTO
    );

    @Operation(summary = "retrieve a banking transaction",
            description = "This operation is used to retrieve a banking transaction")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transaction retrieved",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    ResponseEntity getTransactionByIdentification(@RequestParam String identification,
                                                  @RequestParam String startDate,
                                                  @RequestParam String endDate
    );

}
