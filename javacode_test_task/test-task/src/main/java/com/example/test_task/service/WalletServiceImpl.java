package com.example.test_task.service;

import com.example.test_task.dto.WalletRequest;
import com.example.test_task.dto.WalletResponse;
import com.example.test_task.mapper.WalletMapper;
import com.example.test_task.model.Wallet;
import com.example.test_task.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService{

    private final WalletRepository walletRepository;
    private final WalletMapper walletMapper;
    private final WalletBalanceHandler walletBalanceHandler;
    private static final String NOT_FOUND_WALLET_MESSAGE = "Couldn't find the wallet with the ID: ";

    /**
     * Changes amount of wallet
     *
     * @param walletRequest walletRequest
     * @return walletResponse
     */
    @Override
    public WalletResponse changeWallet(WalletRequest walletRequest) {
        switch (walletRequest.getOperationType()) {
            case "DEPOSIT" -> {
                return walletBalanceHandler.deposit(walletRequest);
            }
            case "WITHDRAW" -> {
                return walletBalanceHandler.withdraw(walletRequest);
            }
            default -> {
                throw new RuntimeException("Unknown operation type");
            }
        }
    }

    /**
     * Gets the value of the wallet balance with the specified ID
     * @param uuid walletResponse
     * @return long value of amount
     */
    @Override
    public long getBalanceById(UUID uuid) {
        Wallet wallet = walletRepository.findById(uuid).orElse(null);
        if (wallet != null) {
            return wallet.getBalance();
        } else {
            throw new RuntimeException(NOT_FOUND_WALLET_MESSAGE + uuid);
        }
    }

    /**
     * Gets all wallets from db
     * @return list of wallets
     */
    @Override
    public List<WalletResponse> getAllWallets() {
        List<Wallet> wallets = walletRepository.findAll();
        if (!wallets.isEmpty()) {
            return walletMapper.toListResponse(wallets);
        } else {
            throw new RuntimeException("Database is empty");
        }
    }

    /**
     * Creates demo-test-database
     */
    @EventListener(ContextRefreshedEvent.class)
    public void CreateDemoDatabase(){
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Wallet wallet = new Wallet();
            wallet.setBalance(random.nextInt(10) * 1000);
            walletRepository.save(wallet);
        }
    }
}
