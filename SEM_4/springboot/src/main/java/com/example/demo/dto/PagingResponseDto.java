package com.example.demo.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PagingResponseDto<T> {
    private int status;
    private String message;

    private int pageNo;
    private int pageSize;
    private long totalRecode;
    private int totalPages;
    private boolean last;

    private List<T> data;
}
