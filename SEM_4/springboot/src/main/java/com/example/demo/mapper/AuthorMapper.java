package com.example.demo.mapper;

import com.example.demo.dto.Author.AuthorRequestDto;
import com.example.demo.dto.Author.AuthorResponseDto;
import com.example.demo.entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") // Để có thể @Autowired trong Service
public interface AuthorMapper {
        AuthorResponseDto toDto(Author author);
        Author toEntity(AuthorRequestDto dto);
}
