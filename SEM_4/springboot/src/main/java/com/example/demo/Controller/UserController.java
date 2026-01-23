package com.example.demo.Controller;

import com.example.demo.Dto.PagingResponseDto;
import com.example.demo.Dto.User.UserResponseDto;
import com.example.demo.Service.UserService;
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
