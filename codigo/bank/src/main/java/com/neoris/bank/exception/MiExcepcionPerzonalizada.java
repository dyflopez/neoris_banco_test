package com.neoris.bank.exception;

import lombok.AllArgsConstructor;

//@AllArgsConstructor
public class MiExcepcionPerzonalizada extends  RuntimeException{

    public MiExcepcionPerzonalizada(String mensaje) {
        super(mensaje);
    }



}
