package com.novabank.infra.adapter.out.mapper;

import com.novabank.infra.repository.entity.SavingsEntity;
import com.novabank.savings.domain.model.Savings;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SavingsOutMapper {

    SavingsEntity toJpa(Savings savings);

    Savings toDomain(SavingsEntity entity);
}
