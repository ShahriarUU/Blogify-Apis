package com.example.Blogify.payloads;

import com.example.Blogify.entities.Audit;
import com.example.Blogify.entities.BlogPost;
import com.example.Blogify.entities.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CommentDto extends Audit {

    @NotEmpty(message = "empty comment not allow")
    private String content;
    private UserDto user;
    private BlogPostDto blogPost;
}
