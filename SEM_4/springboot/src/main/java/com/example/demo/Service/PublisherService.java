package com.example.demo.Service;

import com.example.demo.Dto.PagingResponseDto;
import com.example.demo.Dto.Publisher.PublisherResponseDto;
import com.example.demo.Entity.Publisher;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PublisherService {
    PagingResponseDto<PublisherResponseDto> getAllPublishers(String searching, Pageable pageable);
    Publisher getPublisherById(Long id);
    Publisher createPublisher(Publisher publisher);
    void deletePublisher(Long id);
}
