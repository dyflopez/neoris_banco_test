package com.neoris.bank.exception;

import com.neoris.bank.configs.ExceptionConfigs;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@AllArgsConstructor
public class ControlarExcepcion {

    private final ExceptionConfigs exceptionConfigs;

    @ExceptionHandler(MiExcepcionPerzonalizada.class)
    public ResponseEntity<Object> manejarMiExcepcion(MiExcepcionPerzonalizada ex) {
        log.trace(ExceptionConfigs.PERZONALIZADA + ex.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(exceptionConfigs.getTiposExcepciones(ExceptionConfigs.PERZONALIZADA) + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> manejarExcepcion(Exception ex) {
        log.trace(exceptionConfigs.getTiposExcepciones(ExceptionConfigs.SYSTEMA) + ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionConfigs.getTiposExcepciones(ExceptionConfigs.SYSTEMA) + ex.getMessage());
    }


}
