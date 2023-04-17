package com.neoris.bank.repository;

import com.neoris.bank.model.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository <AccountEntity,Long> {

    Optional<AccountEntity>  findByAccountNumber(String numeroCuenta);

    @Query("SELECT c FROM AccountEntity c WHERE c.client.identification = ?1")
    Optional<List<AccountEntity>> findByIdentificationClient (String identification);



}
