package com.example.demo.Mapper;

import com.example.demo.Dto.Author.AuthorRequestDto;
import com.example.demo.Dto.Author.AuthorResponseDto;
import com.example.demo.Entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") // Để có thể @Autowired trong Service
public interface AuthorMapper {
        AuthorResponseDto toDto(Author author);
        Author toEntity(AuthorRequestDto dto);
}
