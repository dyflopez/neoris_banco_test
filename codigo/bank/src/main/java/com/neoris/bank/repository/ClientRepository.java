package com.neoris.bank.repository;

import com.neoris.bank.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<ClientEntity,Long> {

    Optional<ClientEntity> findByIdentification(String identificacion);

    Optional<ClientEntity> findByIdentificationOrEmail(String identificacion, String email);

}
