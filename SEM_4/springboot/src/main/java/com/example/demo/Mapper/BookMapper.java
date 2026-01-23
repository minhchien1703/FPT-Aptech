package com.example.demo.Mapper;

import com.example.demo.Dto.Book.BookRequestDto;
import com.example.demo.Dto.Book.BookResponseDto;
import com.example.demo.Entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(source = "publisher.name", target = "publisherName")
    BookResponseDto toDto(Book book);

    Book toEntity(BookRequestDto requestDto);
}
