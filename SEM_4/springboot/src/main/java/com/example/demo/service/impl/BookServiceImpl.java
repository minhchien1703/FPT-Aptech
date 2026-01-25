package com.example.demo.service.impl;

import com.example.demo.dto.Book.BookRequestDto;
import com.example.demo.dto.Book.BookResponseDto;
import com.example.demo.dto.PagingResponseDto;
import com.example.demo.entity.Book;
import com.example.demo.mapper.BookMapper;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public PagingResponseDto<BookResponseDto> getAllBooks(String searching, Pageable pageable) {
        Page<Book> bookPage;
        if (searching != null && !searching.isEmpty()) {
            bookPage = bookRepository.findByTitleContainingIgnoreCase(searching, pageable);
        } else {
            bookPage = bookRepository.findAll(pageable);
        }

        // Ánh xạ sang DTO - MapStruct sẽ xử lý nốt phần publisherName và list authors
        Page<BookResponseDto> dtoPage = bookPage.map(bookMapper::toDto);

        return PagingResponseDto.<BookResponseDto>builder()
                .status(200)
                .message("Success.")
                .data(dtoPage.getContent())
                .totalRecode(dtoPage.getTotalElements())
                .totalPages(dtoPage.getTotalPages())
                .build();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sách!"));
    }

    @Override
    @Transactional
    public BookResponseDto createBook(BookRequestDto bookRequestDto) {
        return bookMapper.toDto(bookRepository.save(bookMapper.toEntity(bookRequestDto)));
    }

    @Override
    @Transactional
    public Book updateBook(Long id, Book bookDetails) {
        Book existingBook = getBookById(id);
        existingBook.setTitle(bookDetails.getTitle());
        existingBook.setPublisher(bookDetails.getPublisher());
        existingBook.setAuthors(bookDetails.getAuthors());
        return bookRepository.save(existingBook);
    }

    @Override
    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
