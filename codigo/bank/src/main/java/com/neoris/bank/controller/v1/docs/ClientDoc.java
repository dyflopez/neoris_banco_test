package com.neoris.bank.controller.v1.docs;

import com.neoris.bank.dto.ClientDTO;
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

@Tag(name = "Client", description = "Operations related to clients")
public interface ClientDoc {

    @Operation(summary = "Create client",
            description = "This operation creates a client in the application")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Client created",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    ResponseEntity createClient(
            @Valid @RequestBody ClientDTO clientDTO
    );


    @Operation(summary = "Get all clients",
            description = "This operation lists all clients")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of clients",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    ResponseEntity getAllClients();

    @Operation(summary = "Get client by identification",
            description = "This operation retrieves a client by identification")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client information",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    ResponseEntity getClientByIdentification(@PathVariable String identification);


    @Operation(summary = "Delete client",
            description = "This operation deletes a client by identification")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client deleted",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    ResponseEntity deleteClient(@PathVariable String identification);


    @Operation(summary = "Update client",
            description = "This operation updates a client by identification")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client updated",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    ResponseEntity updateClient(@PathVariable String identification, @Valid @RequestBody ClientDTO userDTO);


}
