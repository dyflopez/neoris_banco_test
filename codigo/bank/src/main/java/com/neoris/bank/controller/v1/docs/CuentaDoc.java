package com.neoris.bank.controller.v1.docs;


import com.neoris.bank.dto.CuentaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "API que se expone para el CRUD de Cuenta ")
public interface CuentaDoc {

    @Operation(summary = "Servicio para crear una Cuenta")
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
    ResponseEntity createCuenta(
            @RequestBody CuentaDTO cuentaDTO
    );

    @Operation(summary = "listar todas las cuentas ")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "lista de Cuentas",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity getCuentas();

    @Operation(summary = "consultar  Cuenta por numero de cuenta")
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
    ResponseEntity consultarCuenta(@PathVariable String numeroCuenta );

    @Operation(summary = "eliminar  Cuenta por numero de cuenta")
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
    ResponseEntity eliminarCuenta(@PathVariable String numeroCuenta );


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
    ResponseEntity updateCliente(@PathVariable String numeroCuenta , @RequestBody CuentaDTO cuentaDTO);

}
