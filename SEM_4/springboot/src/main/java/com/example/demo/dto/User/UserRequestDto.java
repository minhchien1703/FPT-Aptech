package com.example.demo.dto.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequestDto {
    private String name;
    private String email;
    private String password;
}
