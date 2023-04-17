package com.neoris.bank.controller.v1.docs;


import com.neoris.bank.dto.AccountDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;


@Tag(name = "bank account", description = "API exposed for CRUD operations on accounts")
public interface AccountDoc {


    @Operation(summary = "create bank account",
            description = "This operation is for creating accounts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "bank account created",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    ResponseEntity createAccount(
            @RequestBody AccountDTO accountDTO
    );

    @Operation(summary = "List bank accounts",
            description = "This operation is for listing all bank accounts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of bank accounts generated successfully",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    ResponseEntity getAllAccounts();


    @Operation(summary = "Get account by account number",
            description = "This operation is for searching a bank account by account number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bank account information",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    ResponseEntity getAccountByAccountNumber(@PathVariable String accountNumber );


    @Operation(summary = "Delete account by account number",
            description = "This operation is for deleting a bank account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account deleted",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    ResponseEntity deleteAccount(@PathVariable String accountNumber );


    @Operation(summary = "Update account information",
            description = "This operation is for updating account information by account number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account updated",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    ResponseEntity updateAccountByAccountNumber(@PathVariable String accountNumber , @Valid @RequestBody AccountDTO accountDTO);

}
