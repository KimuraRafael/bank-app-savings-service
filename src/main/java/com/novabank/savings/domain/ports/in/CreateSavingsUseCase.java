package com.novabank.savings.domain.ports.in;

import com.novabank.savings.domain.model.Savings;

import java.math.BigDecimal;

public interface CreateSavingsUseCase {

    Savings create(String userId, String description, BigDecimal targetAmount);

}
