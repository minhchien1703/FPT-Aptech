package com.example.demo.Mapper;

import com.example.demo.Dto.Book.BookResponseDto;
import com.example.demo.Dto.Publisher.PublisherResponseDto;
import com.example.demo.Entity.Book;
import com.example.demo.Entity.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PublisherMapper {
    PublisherResponseDto toDto(Publisher publisher);
}
