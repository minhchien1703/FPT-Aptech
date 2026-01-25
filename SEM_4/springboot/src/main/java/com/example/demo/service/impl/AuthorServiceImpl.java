package com.example.demo.service.impl;

import com.example.demo.dto.Author.AuthorRequestDto;
import com.example.demo.dto.Author.AuthorResponseDto;
import com.example.demo.dto.PagingResponseDto;
import com.example.demo.entity.Author;
import com.example.demo.mapper.AuthorMapper;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.service.AuthorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public PagingResponseDto<AuthorResponseDto> getAllAuthors(String searching, Pageable pageable) {
        Page<Author> authorPage;
        if (searching != null && !searching.isEmpty()) {
            authorPage = authorRepository.findByNameContainingIgnoreCase(searching, pageable);
        } else {
            authorPage = authorRepository.findAll(pageable);
        }

        Page<AuthorResponseDto> dtoPage = authorPage.map(authorMapper::toDto);

        return PagingResponseDto.<AuthorResponseDto>builder()
                .status(200)
                .message("Success.")
                .data(dtoPage.getContent())
                .totalRecode(dtoPage.getTotalElements())
                .totalPages(dtoPage.getTotalPages())
                .build();
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tác giả với ID: " + id));
    }

    @Override
    @Transactional
    public AuthorResponseDto createAuthor(AuthorRequestDto authorRequestDto) {
        return authorMapper.toDto(authorRepository.save(authorMapper.toEntity(authorRequestDto)));
    }

    @Override
    @Transactional
    public Author updateAuthor(Long id, Author authorDetails) {
        Author existingAuthor = getAuthorById(id);

        existingAuthor.setName(authorDetails.getName());

        // Cập nhật thông tin profile nếu có gửi kèm
        if (authorDetails.getAuthorProfile() != null) {
            existingAuthor.setAuthorProfile(authorDetails.getAuthorProfile());
        }

        return authorRepository.save(existingAuthor);
    }

    @Override
    @Transactional
    public void deleteAuthor(Long id) {
        Author author = getAuthorById(id);
        authorRepository.delete(author);
    }
}
