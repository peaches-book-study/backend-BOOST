package com.example.week01_test_skeletoncode;

import com.example.week01_test_skeletoncode.global.error.BusinessException;
import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.xml.crypto.Data;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;


@SpringBootTest
class BalanceServiceTest {

    private Account account;

    @Autowired
    private Database database;
//    @MockBean
//    private Database mockDatabase;

    @Autowired
    private BalanceService balanceService;

    @PostConstruct
    void setup() throws Exception {
        database.balance(66L, 10000L);
        database.balance(88L, 10000L);
        database.balance(99L, 0L);
    }


    @Test
    @Order(0)
    @DisplayName("잔액 조회-1")
    void balance_1() throws Exception  {

        //when
        Account account = database.balance(66L);
        //then
        assertThat(account.getBalance()).isEqualTo(10000L);
    }

//    @Test
//    @DisplayName("잔액조회-2")
//    void balance_2() throws Exception {
//
//        //given
//        Mockito.when(mockDatabase.balance(1L))
//                .thenReturn(new Account(0L, System.currentTimeMillis(), System.nanoTime()));
//
//        Account account = balanceService.balance(1L);
//        org.assertj.core.api.Assertions.assertThat(account.getBalance()).isEqualTo(0L);
//
//        verify(mockDatabase).balance(1L);
//    }

    @Test
    @Order(1)
    @DisplayName("잔액 입금")
    void deposit() throws Exception {

        //when
        Account account = balanceService.deposit(66L, 10000L);
        //then
        assertThat(account.getBalance()).isEqualTo(20000L);
    }

    @Test
    @Order(2)
    @DisplayName("잔액 출금")
    void withdraw() throws Exception {
        //when
        Account account = balanceService.withdraw(88L, 10000L);
        //then
        assertThat(account.getBalance()).isEqualTo(0L);

    }
    @Test
    @Order(3)
    @DisplayName("잔액 출금 - 실패(잔액 부족)")
    void withdraw_fail() throws Exception {

        //junit 의 assertThrows
        assertThrows(BusinessException.class, ()->{
            Account account = balanceService.withdraw(88L, 1000000L);
        });

        //assertj 의 assertThatThrownBy
        assertThatThrownBy(() -> balanceService.withdraw(88L, 1000000L))
                .isInstanceOf(BusinessException.class);

    }

    @Test
    @Order(4)
    @DisplayName("잔액 입금 - 동시 요청 1000개")
    void deposit_concurrency() throws Exception {
        final int THREAD_COUNT = 1000;
        Thread[] depositThreads = new Thread[THREAD_COUNT];

        // 각 스레드에 입금 작업 부여
        for (int i = 0; i < THREAD_COUNT; i++) {
            int finalI = i;
            depositThreads[i] = new Thread(() -> {
                try {
                    balanceService.deposit(99L, 1L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        // 스레드 시작
        for (Thread thread : depositThreads) {
            thread.start();
        }
        // 모든 스레드가 종료될 때까지 대기
        for (Thread thread : depositThreads) {
            thread.join();
        }
        Account account = database.balance(99L);
        assertThat(account.getBalance()).isEqualTo(1000L);

    }
}