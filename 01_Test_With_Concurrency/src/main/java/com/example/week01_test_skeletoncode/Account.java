package com.example.week01_test_skeletoncode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class Account {
    private Long balance;
    private Long updateMilli;
    private Long updateNano;
}
