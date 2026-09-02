package com.novabank.infra.adapter.out;


import com.novabank.infra.adapter.out.mapper.SavingsOutMapper;
import com.novabank.infra.repository.SavingsRepository;
import com.novabank.infra.repository.entity.SavingsEntity;
import com.novabank.savings.domain.model.Savings;
import com.novabank.savings.domain.ports.out.SavingsRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SavingsAdapter implements SavingsRepositoryPort{

    private final SavingsRepository jpaRepository;
    private final SavingsOutMapper mapper;


    @Override
    public Savings save(Savings savings) {

        SavingsEntity entity = mapper.toJpa(savings);

        SavingsEntity savedEntity = jpaRepository.save(entity);

        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Savings> findById(String savingsId){

       return jpaRepository.findById(savingsId).map(mapper::toDomain);

    }

    @Override
    public List<Savings> findByUserId(String userId) {
        return jpaRepository.findByUserId(userId).stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(String savingsId){
        jpaRepository.deleteById(savingsId);
    }
}
