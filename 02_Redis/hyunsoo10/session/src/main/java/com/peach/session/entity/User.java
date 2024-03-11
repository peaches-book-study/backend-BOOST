package com.peach.session.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@ToString
@AllArgsConstructor
@Builder
public class User {


    @Id
    private Long id;
    private String username;
    private String password;
    private String name;

}
