package com.example.security_xss_demo.controller;

import com.example.security_xss_demo.dtos.CommentDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/secure_comments")
public class CommentController {

    @PostMapping()
    public String postComment(@Valid @RequestBody CommentDto comment) {
        return "Validated comment" + comment.getComment();
    }

}
