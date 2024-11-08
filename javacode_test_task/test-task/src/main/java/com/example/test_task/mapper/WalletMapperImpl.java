package com.example.test_task.mapper;

import com.example.test_task.dto.WalletRequest;
import com.example.test_task.dto.WalletResponse;
import com.example.test_task.model.Wallet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WalletMapperImpl implements WalletMapper{

    /**
     * Converts instance of WalletRequest to instance Wallet
     * @param walletRequest walletRequest
     * @return wallet
     */
    @Override
    public Wallet toWallet(WalletRequest walletRequest) {
        return null;
    }

    /**
     * Converts instance of Wallet to instance WalletResponse
     * @param wallet wallet
     * @return walletResponse
     */
    @Override
    public WalletResponse toWalletResponse(Wallet wallet) {
        WalletResponse walletResponse = new WalletResponse();
        walletResponse.setWalletId(wallet.getId());
        walletResponse.setBalance(wallet.getBalance());
        return walletResponse;
    }

    /**
     * Converts list of wallets to list of walletResponse
     * @param wallets list of wallets
     * @return list of walletResponse
     */
    @Override
    public List<WalletResponse> toListResponse(List<Wallet> wallets) {
        List<WalletResponse> walletResponses = new ArrayList<>();
        for (Wallet wallet: wallets) {
            WalletResponse walletResponse = this.toWalletResponse(wallet);
            walletResponses.add(walletResponse);
        }
        return walletResponses;
    }
}
