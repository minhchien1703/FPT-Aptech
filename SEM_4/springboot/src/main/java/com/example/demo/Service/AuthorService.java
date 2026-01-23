package com.example.demo.Service;

import com.example.demo.Dto.Author.AuthorRequestDto;
import com.example.demo.Dto.Author.AuthorResponseDto;
import com.example.demo.Dto.PagingResponseDto;
import com.example.demo.Entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuthorService {
    PagingResponseDto<AuthorResponseDto> getAllAuthors(String searching, Pageable pageable);
    Author getAuthorById(Long id);
    AuthorResponseDto createAuthor(AuthorRequestDto authorRequestDto);
    Author updateAuthor(Long id, Author author);
    void deleteAuthor(Long id);
}
