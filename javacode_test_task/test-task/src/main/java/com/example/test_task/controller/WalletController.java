package com.example.test_task.controller;

import com.example.test_task.dto.WalletResponse;
import com.example.test_task.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author Nizovkin A.V.
 */
@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @GetMapping("wallets/{WALLET_UUID}")
    public ResponseEntity<Long> getBalanceById(@PathVariable UUID WALLET_UUID) {
        try {
            return ResponseEntity.ok().body(walletService.getBalanceById(WALLET_UUID));
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }

    @GetMapping("wallet")
    public ResponseEntity<List<WalletResponse>> getAllWallets() {
        try {
            return ResponseEntity.ok().body(walletService.getAllWallets());
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
