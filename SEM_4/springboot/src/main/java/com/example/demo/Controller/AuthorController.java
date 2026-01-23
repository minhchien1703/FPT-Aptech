package com.example.demo.Controller;

import com.example.demo.Dto.Author.AuthorRequestDto;
import com.example.demo.Dto.Author.AuthorResponseDto;
import com.example.demo.Dto.PagingResponseDto;
import com.example.demo.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<PagingResponseDto<AuthorResponseDto>> getAllAuthors(
            @RequestParam(required = false) String searching,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(authorService.getAllAuthors(searching, pageable));
    }

    @PostMapping
    public ResponseEntity<AuthorResponseDto> createAuthor(@RequestBody AuthorRequestDto authorRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.createAuthor(authorRequestDto));
    }
}
