package com.example.week01_test_skeletoncode;

import com.example.week01_test_skeletoncode.global.error.BusinessException;
import com.example.week01_test_skeletoncode.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BalanceService {
    final private Database db;

    // 잔액 확인
    public Account balance(Long id) throws InterruptedException {
        return db.balance(id);
    }

    // 예금
    public Account deposit(Long id, Long amount) throws InterruptedException {
        Account account = db.balance(id);
        return db.balance(id, account.getBalance() + amount);
    }

    // 인출
    public Account withdraw(Long id, Long amount) throws InterruptedException {
        Account account = db.balance(id);
        long afterBalance = account.getBalance() - amount;
        if(afterBalance < 0){
            throw BusinessException.of(ErrorCode.API_ERROR_BALANCE_NOT_SUFFICIENT);
        }
        return db.balance(id, afterBalance);
    }
}
