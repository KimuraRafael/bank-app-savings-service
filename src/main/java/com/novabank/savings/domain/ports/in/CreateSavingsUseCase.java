package com.novabank.savings.domain.ports.in;

import com.novabank.infra.repository.entity.SavingsEntity;
import com.novabank.savings.domain.model.Savings;

public interface CreateSavingsUseCase {

    Savings create(Savings savings);

}
