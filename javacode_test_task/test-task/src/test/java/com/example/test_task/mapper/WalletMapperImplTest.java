package com.example.test_task.mapper;

import com.example.test_task.dto.WalletResponse;
import com.example.test_task.model.Wallet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = WalletMapperImpl.class)
class WalletMapperImplTest {

    @Autowired
    private WalletMapper walletMapper;

    @ParameterizedTest
    @CsvSource({
            "0", "100", "10000000000000000", "-100000000000"
    })
    void toWalletResponseTest(long amount) {
        Wallet expectWallet = new Wallet();
        UUID uuid = UUID.randomUUID();
        expectWallet.setId(uuid);
        expectWallet.setBalance(amount);

        WalletResponse actualWalletResponse = walletMapper.toWalletResponse(expectWallet);

        assertNotNull(actualWalletResponse);
        assertEquals(expectWallet.getId(), actualWalletResponse.getWalletId());
        assertEquals(expectWallet.getBalance(), actualWalletResponse.getBalance());
    }

    @Test
    void toListResponseTest() {
        Random random = new Random();
        List<Wallet> expectWallets = new ArrayList<>();
        for (int i = 0;i < 10; i++) {
            Wallet wallet = new Wallet();
            UUID uuid = UUID.randomUUID();
            wallet.setId(uuid);
            wallet.setBalance(random.nextInt(10) * 1000);
            expectWallets.add(wallet);
        }

        List<WalletResponse> actualWalletResponses = walletMapper.toListResponse(expectWallets);

        assertNotNull(actualWalletResponses);
        assertEquals(expectWallets.size(), actualWalletResponses.size());
        for (WalletResponse walletResponse: actualWalletResponses) {
            boolean found = expectWallets.stream()
                    .filter(wallet -> Objects.equals(walletResponse.getWalletId(), wallet.getId()))
                    .anyMatch(wallet -> Objects.equals(walletResponse.getBalance(), wallet.getBalance()));
            assertTrue(found);
        }
    }
}