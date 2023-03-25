package com.neoris.bank.repository;

import com.neoris.bank.model.MovimientosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MovimientosRepository extends JpaRepository<MovimientosEntity ,Long> {

    @Query("SELECT m FROM MovimientosEntity m WHERE m.cuenta.numeroCuenta = ?1 ORDER BY m.fecha DESC ")
    Optional<List<MovimientosEntity>> buscarMovimientos(String numeroCuenta);


    @Query("SELECT m FROM MovimientosEntity m WHERE m.cuenta.cliente.identificacion = ?1  AND  m.fecha BETWEEN ?2 AND ?3 ORDER BY m.fecha ASC")
    Optional<List<MovimientosEntity>> buscarMovimientosUsuarioFechas(String identificacion, LocalDateTime fechaInicio,LocalDateTime fechaFin);

}
