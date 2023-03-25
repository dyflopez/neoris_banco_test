package com.neoris.bank.mappers;

import com.neoris.bank.dto.ClienteDTO;
import com.neoris.bank.dto.CuentaDTO;
import com.neoris.bank.model.ClienteEntity;
import com.neoris.bank.model.CuentaEntity;

public class CuentaMapper {

    private CuentaMapper (){
    }

    public static CuentaEntity getCuentaDtoToCuentaEntiry(CuentaDTO cuentaDTO, ClienteEntity clienteEntity) {

        return  CuentaEntity
                .builder()
                .numeroCuenta(cuentaDTO.getNumeroCuenta())
                .tipoCuenta(cuentaDTO.getTipoCuenta())
                .saldoInicial(cuentaDTO.getSaldoInicial())
                .estado(cuentaDTO.getEstado())
                .cliente(clienteEntity)
                .build();

    }

    public static CuentaEntity getCuentaEntity(CuentaDTO cuentaDTO, CuentaEntity clienteEntity) {

        return  clienteEntity
                .builder()
                .numeroCuenta(cuentaDTO.getNumeroCuenta())
                .tipoCuenta(cuentaDTO.getTipoCuenta())
                .saldoInicial(cuentaDTO.getSaldoInicial())
                .estado(cuentaDTO.getEstado())
                .cliente(clienteEntity.getCliente())
                .build();

    }
}
