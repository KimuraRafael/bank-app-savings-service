package com.novabank.savings.application.usecases;

import com.novabank.savings.domain.model.Savings;
import com.novabank.savings.domain.ports.in.CreateSavingsUseCase;
import com.novabank.savings.domain.ports.out.SavingsRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SavingsService implements CreateSavingsUseCase {

    private final SavingsRepositoryPort savingsRepositoryPort;

    @Override
    public Savings create(Savings savings) {
        return savingsRepositoryPort.save(savings);
    }
}