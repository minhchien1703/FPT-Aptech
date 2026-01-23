package com.example.demo.Dto.Book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BookResponseDto {
    private Long id;
    private String title;
    private String publisherName;
}
