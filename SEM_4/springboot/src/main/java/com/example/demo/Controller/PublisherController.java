package com.example.demo.Controller;

import com.example.demo.Dto.PagingResponseDto;
import com.example.demo.Dto.Publisher.PublisherResponseDto;
import com.example.demo.Service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @GetMapping
    public ResponseEntity<PagingResponseDto<PublisherResponseDto>> getAllPublishers(
            @RequestParam(required = false) String searching,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(publisherService.getAllPublishers(searching, pageable));
    }

}
