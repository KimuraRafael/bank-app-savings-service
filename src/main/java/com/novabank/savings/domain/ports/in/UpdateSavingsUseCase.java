package com.novabank.savings.domain.ports.in;

import com.novabank.savings.domain.model.Savings;

import java.math.BigDecimal;

public interface UpdateSavingsUseCase {

    Savings update(String savingsId, String description, BigDecimal targetAmount);
}
