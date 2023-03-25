package com.neoris.bank.repository;

import com.neoris.bank.model.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteEntity,Long> {

    Optional<ClienteEntity> findByIdentificacion(String identificacion);


}
