package com.example.test_task.controller;

import com.example.test_task.dto.WalletRequest;
import com.example.test_task.dto.WalletResponse;
import com.example.test_task.model.Wallet;
import com.example.test_task.repository.WalletRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureWebTestClient
@ActiveProfiles("test")
class WalletControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private WalletRepository walletRepository;

    @BeforeEach
    public void setUp() {
        walletRepository.deleteAll();
    }

    @Test
    void getBalanceById() {
        Wallet expectWallet = createTestWallet();

        Long responseBody = webTestClient.get()
                .uri("api/v1/wallets/" + expectWallet.getId())
                .exchange()
                .expectBody(Long.class)
                .returnResult()
                .getResponseBody();

        assertEquals(expectWallet.getBalance(), responseBody);
    }

    @Test
    void getBalanceNotFoundWallet() {
        createDemoDatabase();
        UUID uuid = UUID.randomUUID();

        webTestClient.get()
                .uri("api/v1/wallets/" + uuid)
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void getAllWallets() {
        Random random = new Random();
        List<Wallet> wallets = new ArrayList<>();
        for (int i = 0;i < 10; i++) {
            UUID uuid = UUID.randomUUID();
            Wallet wallet = new Wallet();
            wallet.setId(uuid);
            wallet.setBalance(1000 * random.nextInt(10));
            wallets.add(wallet);
        }
        List<Wallet> expectWallets =  walletRepository.saveAll(wallets);

        List<WalletResponse> responseBody = webTestClient.get()
                .uri("api/v1/wallet")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(WalletResponse.class)
                .returnResult()
                .getResponseBody();

        assertNotNull(responseBody);
        assertEquals(expectWallets.size(), responseBody.size());
        for (WalletResponse walletResponse: responseBody) {
            boolean found = expectWallets.stream()
                    .filter(wallet -> Objects.equals(walletResponse.getWalletId(), wallet.getId()))
                    .anyMatch(wallet -> Objects.equals(walletResponse.getBalance(), wallet.getBalance()));
            assertTrue(found);
        }

    }

    @ParameterizedTest
    @CsvSource({
            "0", "1000", "1000000"
    })
    void changeWalletBalanceDeposit(long amount) {
        Wallet wallet = createTestWallet();
        WalletRequest walletRequest = new WalletRequest();
        walletRequest.setWalletId(wallet.getId());
        walletRequest.setAmount(amount);
        long expectBalance = wallet.getBalance() + amount;
        walletRequest.setOperationType("DEPOSIT");

        WalletResponse responseBody = webTestClient.post()
                .uri("api/v1/wallet")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(walletRequest), WalletRequest.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(WalletResponse.class)
                .returnResult()
                .getResponseBody();

        assertNotNull(responseBody);
        assertEquals(wallet.getId(), responseBody.getWalletId());
        assertEquals(expectBalance, responseBody.getBalance());
    }

    @ParameterizedTest
    @CsvSource({
            "0", "1000", "500"
    })
    void changeWalletBalanceWithdraw(long amount) {
        Wallet wallet = createTestWallet();
        WalletRequest walletRequest = new WalletRequest();
        walletRequest.setWalletId(wallet.getId());
        walletRequest.setAmount(amount);
        long expectBalance = wallet.getBalance() - amount;
        walletRequest.setOperationType("WITHDRAW");

        WalletResponse responseBody = webTestClient.post()
                .uri("api/v1/wallet")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(walletRequest), WalletRequest.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(WalletResponse.class)
                .returnResult()
                .getResponseBody();

        assertNotNull(responseBody);
        assertEquals(wallet.getId(), responseBody.getWalletId());
        assertEquals(expectBalance, responseBody.getBalance());
    }

    @ParameterizedTest
    @CsvSource({
            "100000000", "10000000", "50000000"
    })
    void changeWalletBalanceNotFundsOnBalance(long amount) {
        Wallet wallet = createTestWallet();
        WalletRequest walletRequest = new WalletRequest();
        walletRequest.setWalletId(wallet.getId());
        walletRequest.setAmount(amount);
        long expectBalance = wallet.getBalance() - amount;
        walletRequest.setOperationType("WITHDRAW");

        webTestClient.post()
                .uri("api/v1/wallet")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(walletRequest), WalletRequest.class)
                .exchange()
                .expectStatus().isBadRequest();
    }


    @Test
    void changeWalletBalanceNotFoundWallet() {
        createDemoDatabase();
        UUID uuid = UUID.randomUUID();
        WalletRequest walletRequest = new WalletRequest();
        walletRequest.setWalletId(uuid);
        walletRequest.setAmount(0);
        walletRequest.setOperationType("DEPOSIT");

        webTestClient.post()
                .uri("api/v1/wallet")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(walletRequest), WalletRequest.class)
                .exchange()
                .expectStatus().isBadRequest();
    }

    @ParameterizedTest
    @CsvSource({
            "deposit", "withdraw", "asdfasd"
    })
    void changeWalletBalanceUnknownOperationType(String operationType) {
        Wallet wallet = createTestWallet();
        WalletRequest walletRequest = new WalletRequest();
        walletRequest.setWalletId(wallet.getId());
        walletRequest.setAmount(0);
        walletRequest.setOperationType(operationType);

        webTestClient.post()
                .uri("api/v1/wallet")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(walletRequest), WalletRequest.class)
                .exchange()
                .expectStatus().isBadRequest();
    }

    /**
     * Creates demo wallet database
     */
    private void createDemoDatabase() {
        Random random = new Random();
        List<Wallet> wallets = new ArrayList<>();
        for (int i = 0;i < 10; i++) {
            UUID uuid = UUID.randomUUID();
            Wallet wallet = new Wallet();
            wallet.setId(uuid);
            wallet.setBalance(1000 * random.nextInt(10));
            wallets.add(wallet);
        }
        walletRepository.saveAll(wallets);
    }

    /**
     * Creates random wallet for test
     * @return wallet
     */
    private Wallet createTestWallet() {
        Wallet wallet = new Wallet();
        wallet.setBalance(1000);
        return walletRepository.save(wallet);
    }
}