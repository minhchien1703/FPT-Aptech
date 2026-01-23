package com.example.demo.Service;

import com.example.demo.Dto.PagingResponseDto;
import com.example.demo.Dto.User.UserResponseDto;

public interface UserService {
    PagingResponseDto<UserResponseDto> getAllUser(int pageNo, int pageSize, String searching);
}
