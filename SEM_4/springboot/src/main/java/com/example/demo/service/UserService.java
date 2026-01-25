package com.example.demo.service;

import com.example.demo.dto.PagingResponseDto;
import com.example.demo.dto.User.UserResponseDto;

public interface UserService {
    PagingResponseDto<UserResponseDto> getAllUser(int pageNo, int pageSize, String searching);
}
