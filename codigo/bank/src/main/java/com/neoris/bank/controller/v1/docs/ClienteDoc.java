package com.neoris.bank.controller.v1.docs;

import com.neoris.bank.dto.ClienteDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "API que se expone para el CRUD con Cliente ")
public interface ClienteDoc {

    @Operation(summary = "Servicio para crear un Cliente")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Cuenta creado",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity createUSer(
            @RequestBody ClienteDTO clienteDTO
            );

    @Operation(summary = "listar todos los clientes ")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "lista de clientes",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity getClientes();

    @Operation(summary = "consultar  Cliente por Identificacion")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity consultarUsuario(@PathVariable String identificacion );

    @Operation(summary = "eliminar  Cliente por Identificacion")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity eliminarCliente(@PathVariable String identificacion );


    @Operation(summary = "actualizar informacion del  Cliente")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity updateCliente(@PathVariable String identificacion , @RequestBody ClienteDTO userDTO);


}
