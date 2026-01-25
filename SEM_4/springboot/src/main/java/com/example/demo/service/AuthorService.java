package com.example.demo.service;

import com.example.demo.dto.Author.AuthorRequestDto;
import com.example.demo.dto.Author.AuthorResponseDto;
import com.example.demo.dto.PagingResponseDto;
import com.example.demo.entity.Author;
import org.springframework.data.domain.Pageable;

public interface AuthorService {
    PagingResponseDto<AuthorResponseDto> getAllAuthors(String searching, Pageable pageable);
    Author getAuthorById(Long id);
    AuthorResponseDto createAuthor(AuthorRequestDto authorRequestDto);
    Author updateAuthor(Long id, Author author);
    void deleteAuthor(Long id);
}
