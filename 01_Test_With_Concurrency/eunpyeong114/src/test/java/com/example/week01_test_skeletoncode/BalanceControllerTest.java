package com.example.week01_test_skeletoncode;

import com.example.week01_test_skeletoncode.global.error.BusinessException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BalanceControllerTest{

    @Autowired
    BalanceService bs;

    @Autowired
    Database database;

    @DisplayName("잔액 조회")
    @Test
    public void balanceTest() throws InterruptedException {
        // given
        Long id = 1L;
        // when
        Account account = bs.balance(id);
        // then

        assertEquals(100000L, account.getBalance());
    }

    @DisplayName("입금 처리")
    @Test
    public void depositTest() throws InterruptedException {
        // given
        Long id = 1L;
        Long amount = 2200L;
        Long beforeBalance = bs.balance(id).getBalance();
        // when
        Account deposit = bs.deposit(id,amount);
        // then
        assertEquals(beforeBalance+amount,deposit.getBalance());
    }
    @DisplayName("출금 성공 처리")
    @Test
    public void withdrawalTest() throws InterruptedException {
        // given
        Long id = 1L;
        Long amount = 1000L;
        Long afterBalance = bs.balance(id).getBalance()-amount;
        // when
        Account balance = bs.withdraw(id,amount);
        // then
        assertEquals(afterBalance,balance.getBalance());

    }

    @DisplayName("출금 실패 처리")
    @Test
    public void withdrawFail() throws InterruptedException {
        // given
        Long id = 1L;
        Long amount = 1000001L;
        Long afterAmount = bs.balance(id).getBalance() - amount;

        // when
        // then
        BusinessException e = Assertions.assertThrows(BusinessException.class,()->bs.withdraw(id,amount));
    }

    // 미완
    @DisplayName("동시성 입금 테스트")
    @Test
    public void concurrencyDeposit() throws InterruptedException {
        // given
        Long id1= 1L;
        Long account1 = 1L;

        Long id2 = 1L;
        Long account2 = 2L;
        // when
        Account firstAccount = bs.deposit(id1,account1);
        Account secondAccount = bs.deposit(id2,account2);
        // then
        assertEquals(100001L,firstAccount.getBalance());
        assertEquals(100003L, secondAccount.getBalance());
    }

}