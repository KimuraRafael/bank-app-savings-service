package com.novabank.savings.domain.ports.in;

import com.novabank.savings.domain.model.Savings;

import java.util.List;

public interface GetSavingsUseCase {

        List<Savings> findByUserId(String userId);
}
