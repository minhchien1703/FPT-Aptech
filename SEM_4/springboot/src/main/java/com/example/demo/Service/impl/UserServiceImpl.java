package com.example.demo.Service.impl;

import com.example.demo.Dto.PagingResponseDto;
import com.example.demo.Dto.User.UserResponseDto;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public PagingResponseDto<UserResponseDto> getAllUser(int pageNo, int pageSize, String searching) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<User> userPage = repository.findByNameContainingIgnoreCase(searching, pageable);

        Page<UserResponseDto> dtoPage = userPage.map(user -> {
            UserResponseDto dto = new UserResponseDto();
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setEmail(user.getEmail());
            return dto;
        });

        return PagingResponseDto.<UserResponseDto>builder()
                .status(200)
                .message("success")
                .pageNo(dtoPage.getNumber())
                .pageSize(dtoPage.getSize())
                .totalRecode(dtoPage.getTotalElements())
                .totalPages(dtoPage.getTotalPages())
                .data(dtoPage.getContent())
                .build();
    }



}
