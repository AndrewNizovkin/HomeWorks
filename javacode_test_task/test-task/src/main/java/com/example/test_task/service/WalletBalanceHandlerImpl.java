package com.example.test_task.service;

import com.example.test_task.dto.WalletRequest;
import com.example.test_task.dto.WalletResponse;
import com.example.test_task.mapper.WalletMapper;
import com.example.test_task.model.Wallet;
import com.example.test_task.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * This class implements interface WalletBalanceHandler
 * @author Nizovkin A.V.
 */
@Component
@RequiredArgsConstructor
public class WalletBalanceHandlerImpl implements WalletBalanceHandler{
    private final WalletRepository walletRepository;
    private final WalletMapper walletMapper;
    private static final String NOT_FOUND_WALLET_MESSAGE = "Couldn't find the wallet with the ID: ";
    private static final String NOT_FUNDS_ON_BALANCE = "There are not enough funds on the balance of the wallet with the ID: ";


    /**
     * Adds amount to the wallet balance
     *
     * @param walletRequest walletRequest
     * @return walletResponse
     */
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public WalletResponse deposit(WalletRequest walletRequest) {
        UUID walletId = walletRequest.getWalletId();
        Wallet wallet = walletRepository.findById(walletId).orElse(null);
        if (wallet != null) {
            wallet.setBalance(wallet.getBalance() + walletRequest.getAmount());
            return walletMapper.toWalletResponse(walletRepository.save(wallet));
        } else {
            throw new RuntimeException(NOT_FOUND_WALLET_MESSAGE + walletRequest.getWalletId());
        }
    }

    /**
     * Withdraws funds from the wallet balance
     *
     * @param walletRequest walletRequest
     * @return walletResponse
     */
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public WalletResponse withdraw(WalletRequest walletRequest) {
        UUID walletId = walletRequest.getWalletId();
        Wallet wallet = walletRepository.findById(walletId).orElse(null);
        if (wallet != null) {
            if (wallet.getBalance() >= walletRequest.getAmount()) {
                wallet.setBalance(wallet.getBalance() - walletRequest.getAmount());
                return walletMapper.toWalletResponse(walletRepository.save(wallet));
            } else {
                throw new RuntimeException(NOT_FUNDS_ON_BALANCE + wallet.getId());
            }
        } else {
            throw new RuntimeException(NOT_FOUND_WALLET_MESSAGE + walletRequest.getWalletId());
        }
    }
}
