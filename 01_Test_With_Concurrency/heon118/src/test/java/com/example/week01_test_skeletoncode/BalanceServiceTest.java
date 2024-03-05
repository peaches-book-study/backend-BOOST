package com.example.week01_test_skeletoncode;


import com.example.week01_test_skeletoncode.global.error.BusinessException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class BalanceServiceTest {
//    @InjectMocks
//    private BalanceService balanceService;
//    @Mock
//    private Database database;

    @Autowired
    BalanceService balanceService;
    @Autowired
    Database database;

    @Test
    @DisplayName("잔액 확인 테스트")
    void balance() throws InterruptedException {
        // GIVEN
        Long id = 1L;

        // WHEN
        Account account = balanceService.balance(id);

        // THEN
        assertThat(account).isEqualTo(database.balance(id));
    }

    @Test
    @DisplayName("입금 테스트")
    void deposit() throws InterruptedException {
        // GIVEN
        Long id = 2L;
        Long amount = 5000L;

        // WHEN
        Account account = balanceService.deposit(id, amount);

        // THEN
        assertThat(account.getBalance()).isEqualTo(amount);
    }

    @DisplayName("출금 테스트")
    @Nested
    class withdraw {
        @Test
        @DisplayName("출금 성공")
        void whenSuccess() throws InterruptedException {
            // GIVEN
            Long id = 3L;
            Long amount = 7777L;

            // WHEN
            Long beforeBalance = balanceService.balance(id).getBalance();
            Account account = balanceService.withdraw(id, amount);

            // THEN
            assertThat(account.getBalance()).isEqualTo(beforeBalance - amount);
        }

        @Test
        @DisplayName("출금 실패, 잔액 부족")
        void whenFail() {
            // GIVEN
            Long id = 2L;
            Long amount = 50000L;

            // WHEN
            assertThrows(BusinessException.class, () -> {
                balanceService.withdraw(id, amount);
            }, "잔액이 부족합니다!!!");
        }
    }

    @Test
    @DisplayName("동시성테스트")
    void concurrencyTest(){
        // WHEN
        int numberofThreads = 10;
        ExecutorService service = Executors.newFixedThreadPool(10);
    }

}
