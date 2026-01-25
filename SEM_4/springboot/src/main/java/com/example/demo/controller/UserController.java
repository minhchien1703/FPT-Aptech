package com.example.demo.controller;

import com.example.demo.dto.PagingResponseDto;
import com.example.demo.dto.User.UserResponseDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public PagingResponseDto<UserResponseDto> getAllUsers(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(required = false) String searching
    ) {
        return userService.getAllUser(pageNo, pageSize, searching);
    }


}
