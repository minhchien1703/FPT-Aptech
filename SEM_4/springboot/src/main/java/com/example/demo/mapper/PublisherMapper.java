package com.example.demo.mapper;

import com.example.demo.dto.Book.BookResponseDto;
import com.example.demo.dto.Publisher.PublisherResponseDto;
import com.example.demo.entity.Book;
import com.example.demo.entity.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PublisherMapper {
    PublisherResponseDto toDto(Publisher publisher);
}
