package com.novabank.savings.domain.ports.out;

import com.novabank.savings.domain.model.Savings;

import java.util.List;
import java.util.Optional;

public interface SavingsRepositoryPort {

    Savings save(Savings savings);

    Optional<Savings> findById(String id);

    List<Savings> findByUserId(String id);

    void deleteById(String id);

}
