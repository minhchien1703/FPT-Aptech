package com.example.security_xss_demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class CommentDto {

    @NotBlank(message = "Comment is not true")
    @Pattern(regexp = "^[a-zA-Z0-9\\s,.!?]*$", message = "Comment contains illegal characters")
    private String comment;

    public  String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
