package com.example.test_task.service;

import com.example.test_task.dto.WalletRequest;
import com.example.test_task.dto.WalletResponse;
import com.example.test_task.mapper.WalletMapper;
import com.example.test_task.mapper.WalletMapperImpl;
import com.example.test_task.model.Wallet;
import com.example.test_task.repository.WalletRepository;
import org.junit.jupiter.api.BeforeAll;
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
        WalletServiceImpl.class,
        WalletBalanceHandlerImpl.class,
        WalletMapperImpl.class
})
class WalletServiceImplTest {

    @Autowired
    private WalletService walletService;

    @MockBean
    private WalletRepository walletRepository;

    @Autowired
    private WalletBalanceHandler walletBalanceHandler;

    @Autowired
    private WalletMapper walletMapper;

    @ParameterizedTest
    @CsvSource({
            "1000, 100, WITHDRAW",
            "0, 0, WITHDRAW"
    })
    void changeWalletWithdraw(long balance, long amount, String operationType) {
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

        WalletResponse walletResponseActual = walletService.changeWallet(walletRequest);

        assertNotNull(walletResponseActual);
        assertEquals(uuid, walletResponseActual.getWalletId());
        assertEquals(walletAfterWithdraw.getBalance(), walletResponseActual.getBalance());
    }

    @ParameterizedTest
    @CsvSource({
            "1000, 100, DEPOSIT",
            "0, 0, DEPOSIT"
    })
    void changeWalletDeposit(long balance, long amount, String operationType) {
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
        walletRequest.setOperationType("WITHDRAW");

        WalletResponse walletResponseActual = walletService.changeWallet(walletRequest);

        assertNotNull(walletResponseActual);
        assertEquals(uuid, walletResponseActual.getWalletId());
        assertEquals(walletAfterDeposit.getBalance(), walletResponseActual.getBalance());
    }

    @ParameterizedTest
    @CsvSource({
            "1000, DEPOSIT",
            "1000, WITHDRAW"
    })
    void changeWalletNotFoundWallet() {
        UUID uuid = UUID.randomUUID();
        WalletRequest walletRequest = new WalletRequest();
        walletRequest.setWalletId(uuid);
        walletRequest.setAmount(1000);
        walletRequest.setOperationType("DEPOSIT");
        Mockito.when(walletRepository.findById(Mockito.any(UUID.class))).thenReturn(null);

        assertThrows(RuntimeException.class, () -> walletService.changeWallet(walletRequest));
    }

    @ParameterizedTest
    @CsvSource({
            "WITDRAW", "DEOSIT", "asdf", "deposit", "withdraw"
    })
    void changeWalletUnknownOperationType(String operationType) {
        UUID uuid = UUID.randomUUID();
        Wallet wallet = new Wallet();
        wallet.setId(uuid);
        WalletRequest walletRequest = new WalletRequest();
        walletRequest.setWalletId(uuid);
        walletRequest.setAmount(1000);
        walletRequest.setOperationType(operationType);
        Mockito.when(walletRepository.findById(Mockito.any(UUID.class))).thenReturn(Optional.of(wallet));

        assertThrows(RuntimeException.class, () -> walletService.changeWallet(walletRequest));
    }


    @ParameterizedTest
    @CsvSource({
            "0", "100", "100000000000000"
    })
    void getBalanceById(long balance) {
        UUID uuid = UUID.randomUUID();
        Wallet expectlWallet = new Wallet();
        expectlWallet.setId(uuid);
        expectlWallet.setBalance(balance);
        Mockito.when(walletRepository.findById(Mockito.any(UUID.class))).thenReturn(Optional.of(expectlWallet));

        long actualBalance = walletService.getBalanceById(uuid);

        assertEquals(expectlWallet.getBalance(), actualBalance);
    }

    @Test
    void getBalanceByIdNotFoundWallet() {
        UUID uuid = UUID.randomUUID();
        Mockito.when(walletRepository.findById(Mockito.any(UUID.class))).thenReturn(null);

        assertThrows(RuntimeException.class, () -> walletService.getBalanceById(uuid));
    }
}