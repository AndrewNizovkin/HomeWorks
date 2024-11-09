package com.example.test_task.service;

import com.example.test_task.mapper.WalletMapper;
import com.example.test_task.mapper.WalletMapperImpl;
import com.example.test_task.repository.WalletRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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

//    @Autowired
//    private WalletBalanceHandler walletBalanceHandler;
//
//    @Autowired
//    private WalletMapper walletMapper;



    @Test
    void changeWallet() {
    }

    @Test
    void getBalanceById() {

    }
}