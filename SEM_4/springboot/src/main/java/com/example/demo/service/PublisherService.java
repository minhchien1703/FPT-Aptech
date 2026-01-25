package com.example.demo.service;

import com.example.demo.dto.PagingResponseDto;
import com.example.demo.dto.Publisher.PublisherResponseDto;
import com.example.demo.entity.Publisher;
import org.springframework.data.domain.Pageable;

public interface PublisherService {
    PagingResponseDto<PublisherResponseDto> getAllPublishers(String searching, Pageable pageable);
    Publisher getPublisherById(Long id);
    Publisher createPublisher(Publisher publisher);
    void deletePublisher(Long id);
}
