package com.example.test_task.service;

import com.example.test_task.dto.WalletRequest;
import com.example.test_task.dto.WalletResponse;

import java.util.List;
import java.util.UUID;

/**
 * This interface defines the methods of the business logic of the project
 * @author Nizovkin A.V.
 */
public interface WalletService {

    /**
     * Changes amount of wallet
     * @param walletRequest walletRequest
     * @return walletResponse
     */
    WalletResponse changeWallet(WalletRequest walletRequest);

    /**
     * Gets the value of the wallet balance with the specified ID
     * @param uuid ID
     * @return long value of amount
     */
    long getBalanceById(UUID uuid);

    /**
     * Gets all wallets from db
     * @return list of wallets
     */
    List<WalletResponse> getAllWallets();

}
