package com.example.week01_test_skeletoncode;

import io.swagger.v3.core.util.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.GsonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class BalanceControllerTest {

    @InjectMocks
    private BalanceController balanceController;
    @Mock
    private BalanceService balanceService;

    @Autowired
    MockMvc mockMvc;



    @Test
    @DisplayName("1-1 입금")
    void test1_1() throws Exception {
        Long amount = 1000L;

        mockMvc.perform(post("/account/77/deposit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.balance").value(1000));

    }

    void test2_init() throws Exception{
        Long amount = 1000L;

        mockMvc.perform(post("/account/88/deposit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(amount)));
    }

    @Test
    @DisplayName("2-1 출금 - 성공")
    void test2_1() throws Exception {
        test2_init();
        Long amount = 500L;

        mockMvc.perform(post("/account/88/withdraw")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.balance").value(500));
    }
    @Test
    @DisplayName("2-2 출금 - 실패(잔액 부족)")
    void test2_2() throws Exception {
        test2_init();
        Long amount = 500000L;

        mockMvc.perform(post("/account/88/withdraw")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(amount)))
                .andExpect(status().is4xxClientError())
                .andExpect(content().json(
                        """
                {
                "businessCode":"B001",
                "errorMessage":"잔액이 부족합니다.",
                "errors":null
                }
                """
                ));
    }
}