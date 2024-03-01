package com.example.week01_test_skeletoncode;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class BalanceController {
    final private BalanceService balanceService;

    // 잔액 확인
    @GetMapping("{id}/balance")
    Account balance(@PathVariable Long id) throws InterruptedException {
        return balanceService.balance(id);
    }

    // 예금
    @PostMapping("{id}/deposit")
    Account deposit(@PathVariable Long id, @RequestBody Long amount) throws InterruptedException {
        return balanceService.deposit(id, amount);
    }

    // 인출
    @PostMapping("{id}/withdraw")
    Account withdraw(@PathVariable Long id, @RequestBody Long amount) throws InterruptedException {
        return balanceService.withdraw(id, amount);
    }
}
