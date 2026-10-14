package com.novabank.savings.application.usecases;

import com.novabank.savings.domain.model.Savings;
import com.novabank.savings.domain.ports.in.CreateSavingsUseCase;
import com.novabank.savings.domain.ports.in.DeleteSavingsUseCase;
import com.novabank.savings.domain.ports.in.GetSavingsUseCase;
import com.novabank.savings.domain.ports.in.UpdateSavingsUseCase;
import com.novabank.savings.domain.ports.out.SavingsRepositoryPort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service

public class SavingsService implements CreateSavingsUseCase, GetSavingsUseCase, DeleteSavingsUseCase, UpdateSavingsUseCase {

    private final SavingsRepositoryPort savingsRepositoryPort;
    private Savings savings;

    public SavingsService(SavingsRepositoryPort savingsRepositoryPort) {
        this.savingsRepositoryPort = savingsRepositoryPort;
    }

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

    @Override
    public Savings update(String savingsId, String description, BigDecimal targetAmount){
        Savings savings = savingsRepositoryPort.findById(savingsId)
                .orElseThrow(() -> new IllegalArgumentException("Savings not found: " + savingsId));

        savings.update(description, targetAmount);

        return savingsRepositoryPort.save(savings);
    }

    @Override
    public void delete(String savingsId){
//        if (savings.getBalance().compareTo(BigDecimal.ZERO) > 0) {
//            throw new IllegalStateException(
//                    "Cofrinho com valor não pode ser deletado"
//            );
//        }
        savingsRepositoryPort.deleteById(savingsId);
    }

}