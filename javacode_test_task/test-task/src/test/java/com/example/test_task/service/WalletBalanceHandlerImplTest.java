package com.example.test_task.service;

import com.example.test_task.dto.WalletRequest;
import com.example.test_task.dto.WalletResponse;
import com.example.test_task.mapper.WalletMapper;
import com.example.test_task.mapper.WalletMapperImpl;
import com.example.test_task.model.Wallet;
import com.example.test_task.repository.WalletRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {
        WalletBalanceHandlerImpl.class,
        WalletMapperImpl.class
})
class WalletBalanceHandlerImplTest {

    @Autowired
    private WalletMapper walletMapper;

    @Autowired
    private WalletBalanceHandler walletBalanceHandler;

    @MockBean
    private WalletRepository walletRepository;

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1000, 100",
            "1000000000000, 10000000000"
    })
    void depositTest(long balance, long amount) {
        UUID uuid = UUID.randomUUID();
        Wallet walletBeforeDeposit = new Wallet();
        walletBeforeDeposit.setId(uuid);
        walletBeforeDeposit.setBalance(balance);
        Wallet walletAfterDeposit = new Wallet();
        walletAfterDeposit.setId(uuid);
        walletAfterDeposit.setBalance(balance + amount);
        Mockito.when(walletRepository.findById(Mockito.any(UUID.class))).thenReturn(Optional.of(walletBeforeDeposit));
        Mockito.when(walletRepository.save(Mockito.any(Wallet.class))).thenReturn(walletAfterDeposit);
        WalletRequest walletRequest = new WalletRequest();
        walletRequest.setWalletId(uuid);
        walletRequest.setAmount(amount);
        walletRequest.setOperationType("DEPOSIT");

        WalletResponse walletResponseActual = walletBalanceHandler.deposit(walletRequest);

        assertNotNull(walletResponseActual);
        assertEquals(uuid, walletResponseActual.getWalletId());
        assertEquals(walletAfterDeposit.getBalance(), walletResponseActual.getBalance());
    }

    @Test
    void depositTestNotFoundWallet() {
        UUID uuid = UUID.randomUUID();
        WalletRequest walletRequest = new WalletRequest();
        walletRequest.setWalletId(uuid);
        walletRequest.setAmount(100);
        walletRequest.setOperationType("DEPOSIT");
        Mockito.when(walletRepository.findById(Mockito.any(UUID.class))).thenReturn(null);

        assertThrows(RuntimeException.class, () -> walletBalanceHandler.deposit(walletRequest));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1000, 100",
            "1000000000000, 10000000000"
    })
    void withdrawTest(long balance, long amount) {
        UUID uuid = UUID.randomUUID();
        Wallet walletBeforeWithdraw = new Wallet();
        walletBeforeWithdraw.setId(uuid);
        walletBeforeWithdraw.setBalance(balance);
        Wallet walletAfterWithdraw = new Wallet();
        walletAfterWithdraw.setId(uuid);
        walletAfterWithdraw.setBalance(balance - amount);
        Mockito.when(walletRepository.findById(Mockito.any(UUID.class))).thenReturn(Optional.of(walletBeforeWithdraw));
        Mockito.when(walletRepository.save(Mockito.any(Wallet.class))).thenReturn(walletAfterWithdraw);
        WalletRequest walletRequest = new WalletRequest();
        walletRequest.setWalletId(uuid);
        walletRequest.setAmount(amount);
        walletRequest.setOperationType("WITHDRAW");

        WalletResponse walletResponseActual = walletBalanceHandler.withdraw(walletRequest);

        assertNotNull(walletResponseActual);
        assertEquals(uuid, walletResponseActual.getWalletId());
        assertEquals(walletAfterWithdraw.getBalance(), walletResponseActual.getBalance());
    }

    @Test
    void withdrawTestNotFoundWallet() {
        UUID uuid = UUID.randomUUID();
        WalletRequest walletRequest = new WalletRequest();
        walletRequest.setWalletId(uuid);
        walletRequest.setAmount(100);
        walletRequest.setOperationType("DEPOSIT");
        Mockito.when(walletRepository.findById(Mockito.any(UUID.class))).thenReturn(null);

        assertThrows(RuntimeException.class, () -> walletBalanceHandler.withdraw(walletRequest));
    }

    @Test
    void withdrawTestNotFundsOnBalance() {
        UUID uuid = UUID.randomUUID();
        Wallet walletBeforeDeposit = new Wallet();
        walletBeforeDeposit.setId(uuid);
        walletBeforeDeposit.setBalance(100);
        WalletRequest walletRequest = new WalletRequest();
        walletRequest.setWalletId(uuid);
        walletRequest.setAmount(101);
        walletRequest.setOperationType("WITHDRAW");
        Mockito.when(walletRepository.findById(Mockito.any(UUID.class))).thenReturn(Optional.of(walletBeforeDeposit));

        assertThrows(RuntimeException.class, () -> walletBalanceHandler.withdraw(walletRequest));
    }
}