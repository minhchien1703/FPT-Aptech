package com.example.demo.Service;

import com.example.demo.Dto.Book.BookRequestDto;
import com.example.demo.Dto.Book.BookResponseDto;
import com.example.demo.Dto.PagingResponseDto;
import com.example.demo.Entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    PagingResponseDto<BookResponseDto> getAllBooks(String searching, Pageable pageable);
    Book getBookById(Long id);
    BookResponseDto createBook(BookRequestDto bookRequestDto);
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);
}
