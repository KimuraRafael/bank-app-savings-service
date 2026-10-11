package com.novabank.savings.application.usecases;

import com.novabank.savings.domain.model.Savings;
import com.novabank.savings.domain.ports.in.CreateSavingsUseCase;
import com.novabank.savings.domain.ports.in.GetSavingsUseCase;
import com.novabank.savings.domain.ports.out.SavingsRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SavingsService implements CreateSavingsUseCase, GetSavingsUseCase {

    private final SavingsRepositoryPort savingsRepositoryPort;

    @Override
    public Savings create(
            String userId,
            String description,
            BigDecimal targetAmount) {

        Savings savings = Savings.create(
                userId,
                description,
                targetAmount
        );

        return savingsRepositoryPort.save(savings);
    }

    @Override
    public List<Savings> findByUserId(String userId){
        return savingsRepositoryPort.findByUserId(userId);

    }

}