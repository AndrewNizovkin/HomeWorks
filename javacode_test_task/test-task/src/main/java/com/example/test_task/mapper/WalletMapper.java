package com.example.test_task.mapper;

import com.example.test_task.dto.WalletRequest;
import com.example.test_task.dto.WalletResponse;
import com.example.test_task.model.Wallet;

import java.util.List;

/**
 * This interface defines a set of methods for converting between
 * dto objects and entities
 */
public interface WalletMapper {

    /**
     * Converts instance of WalletRequest to instance Wallet
     * @param walletRequest walletRequest
     * @return wallet
     */
    Wallet toWallet(WalletRequest walletRequest);

    /**
     * Converts instance of Wallet to instance WalletResponse
     * @param wallet wallet
     * @return walletResponse
     */
    WalletResponse toWalletResponse(Wallet wallet);

    /**
     * Converts list of wallets to list of walletResponse
     * @param wallets list of wallets
     * @return list of walletResponse
     */
    List<WalletResponse> toListResponse(List<Wallet> wallets);
}
