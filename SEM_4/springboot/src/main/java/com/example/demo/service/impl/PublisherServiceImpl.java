package com.example.demo.service.impl;

import com.example.demo.dto.PagingResponseDto;
import com.example.demo.dto.Publisher.PublisherResponseDto;
import com.example.demo.entity.Publisher;
import com.example.demo.mapper.PublisherMapper;
import com.example.demo.repository.PublisherRepository;
import com.example.demo.service.PublisherService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private PublisherMapper publisherMapper;

    @Override
    public PagingResponseDto<PublisherResponseDto> getAllPublishers(String searching, Pageable pageable) {
        Page<Publisher> publisherPage;

        if (searching != null && !searching.isEmpty()) {
            publisherPage = publisherRepository.findByNameContainingIgnoreCase(searching, pageable);
        } else {
            publisherPage = publisherRepository.findAll(pageable);
        }

        Page<PublisherResponseDto> dtoPage = publisherPage.map(publisherMapper::toDto);

        return PagingResponseDto.<PublisherResponseDto>builder()
                .status(200)
                .message("Success.")
                .data(dtoPage.getContent())
                .totalRecode(dtoPage.getTotalElements())
                .totalPages(dtoPage.getTotalPages())
                .build();
    }

    @Override
    public Publisher getPublisherById(Long id) {
        return publisherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy NXB!"));
    }

    @Override
    @Transactional
    public Publisher createPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    @Transactional
    public void deletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }
}
