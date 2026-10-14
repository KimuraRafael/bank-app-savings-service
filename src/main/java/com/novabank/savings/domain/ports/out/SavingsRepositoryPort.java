package com.novabank.savings.domain.ports.out;

import com.novabank.savings.domain.model.Savings;

import java.util.List;
import java.util.Optional;

public interface SavingsRepositoryPort {

    Savings save(Savings savings);

    List<Savings> findByUserId(String id);

    Optional<Savings> findById(String savingsId);


    void deleteById(String id);



}
