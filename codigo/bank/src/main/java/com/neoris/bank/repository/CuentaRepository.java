package com.neoris.bank.repository;

import com.neoris.bank.model.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CuentaRepository extends JpaRepository <CuentaEntity,Long> {

    Optional<CuentaEntity>  findByNumeroCuenta(String numeroCuenta);

    @Query("SELECT c FROM CuentaEntity c WHERE c.cliente.identificacion = ?1")
    Optional<List<CuentaEntity>> findByClienteIdentidicacion (String identificacion);



}
