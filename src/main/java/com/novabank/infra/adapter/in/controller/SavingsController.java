package com.novabank.infra.adapter.in.controller;

import com.novabank.infra.adapter.in.dto.CreateSavingsRequest;
import com.novabank.infra.adapter.in.dto.SavingsResponse;
import com.novabank.savings.domain.model.Savings;
import com.novabank.savings.domain.ports.in.CreateSavingsUseCase;
import com.novabank.savings.domain.ports.in.GetSavingsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/savings")
@RequiredArgsConstructor
public class SavingsController {

    private final CreateSavingsUseCase createSavingsUseCase;
    private final GetSavingsUseCase getSavingsUseCase;

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

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SavingsResponse>> findByUserId(@PathVariable String userId){

        List<SavingsResponse> response = getSavingsUseCase
                .findByUserId(userId)
                .stream()
                .map(savings -> new SavingsResponse(
                        savings.getId(),
                        savings.getUserId(),
                        savings.getDescription(),
                        savings.getTargetAmount(),
                        savings.getBalance(),
                        savings.getCreatedAt()
                ))
                .toList();

        return ResponseEntity.ok(response);
    }
}