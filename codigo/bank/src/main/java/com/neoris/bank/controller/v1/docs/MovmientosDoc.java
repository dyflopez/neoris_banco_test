package com.neoris.bank.controller.v1.docs;

import com.neoris.bank.dto.MovimientoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Tag(name = "API para Movmientos bancarios ")
public interface MovmientosDoc {

    @Operation(summary = "Servicio para crear un movimiento")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "movimiento creado",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity createMovimiento(
            @RequestBody MovimientoDTO movimientoDTO
            );

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
    ResponseEntity consultarCuenta(@RequestParam String identificacion,
                                   @RequestParam String fechaInicio ,
                                   @RequestParam String fechaFin
    );
}
