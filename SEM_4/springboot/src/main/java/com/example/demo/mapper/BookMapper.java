package com.example.demo.mapper;

import com.example.demo.dto.Book.BookRequestDto;
import com.example.demo.dto.Book.BookResponseDto;
import com.example.demo.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(source = "publisher.name", target = "publisherName")
    BookResponseDto toDto(Book book);

    Book toEntity(BookRequestDto requestDto);
}
