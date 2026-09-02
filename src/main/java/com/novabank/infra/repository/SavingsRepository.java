package com.novabank.infra.repository;


import com.novabank.infra.repository.entity.SavingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SavingsRepository extends JpaRepository<SavingsEntity, String> {

    List<SavingsEntity> findByUserId(String userId);
    
}
