package com.example.demo.service;

import com.example.demo.dto.Book.BookRequestDto;
import com.example.demo.dto.Book.BookResponseDto;
import com.example.demo.dto.PagingResponseDto;
import com.example.demo.entity.Book;
import org.springframework.data.domain.Pageable;

public interface BookService {
    PagingResponseDto<BookResponseDto> getAllBooks(String searching, Pageable pageable);
    Book getBookById(Long id);
    BookResponseDto createBook(BookRequestDto bookRequestDto);
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);
}
