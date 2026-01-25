package com.example.demo.controller;

import com.example.demo.dto.Book.BookRequestDto;
import com.example.demo.dto.Book.BookResponseDto;
import com.example.demo.dto.PagingResponseDto;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<PagingResponseDto<BookResponseDto>> getAllBooks(
            @RequestParam(required = false) String searching,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(bookService.getAllBooks(searching, pageable));
    }

    @PostMapping
    public ResponseEntity<BookResponseDto> Create(@RequestBody BookRequestDto bookRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(bookRequestDto));
    }
}
