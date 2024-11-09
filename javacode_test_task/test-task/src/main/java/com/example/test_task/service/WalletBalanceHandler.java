package com.example.test_task.service;

import com.example.test_task.dto.WalletRequest;
import com.example.test_task.dto.WalletResponse;

/**
 * This interface defines methods for changing the wallet balance.
 * @author Nizovkin A.V.
 */
public interface WalletBalanceHandler {

    /**
     * Adds amount to the wallet balance
     * @param walletRequest walletRequest
     * @return walletResponse
     */
    WalletResponse deposit(WalletRequest walletRequest);

    /**
     * Withdraws funds from the wallet balance
     * @param walletRequest walletRequest
     * @return walletResponse
     */
    WalletResponse withdraw(WalletRequest walletRequest);

}
