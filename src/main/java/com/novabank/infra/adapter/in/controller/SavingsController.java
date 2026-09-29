package com.novabank.infra.adapter.in.controller;

import com.novabank.infra.adapter.in.dto.CreateSavingsRequest;
import com.novabank.infra.adapter.in.dto.SavingsResponse;
import com.novabank.savings.domain.model.Savings;
import com.novabank.savings.domain.ports.in.CreateSavingsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/savings")
@RequiredArgsConstructor
public class SavingsController {

    private final CreateSavingsUseCase createSavingsUseCase;

    @PostMapping
    public ResponseEntity<SavingsResponse> create(
            @RequestBody CreateSavingsRequest request
    ) {

        Savings savings = createSavingsUseCase.create(
                request.userId(),
                request.description(),
                request.targetAmount()
        );

        SavingsResponse response = new SavingsResponse(
                savings.getId(),
                savings.getUserId(),
                savings.getDescription(),
                savings.getTargetAmount(),
                savings.getBalance(),
                savings.getCreatedAt()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}