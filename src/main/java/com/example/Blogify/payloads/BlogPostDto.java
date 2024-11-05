package com.example.Blogify.payloads;

import com.example.Blogify.entities.Audit;
import com.example.Blogify.entities.Category;
import com.example.Blogify.entities.Comment;
import com.example.Blogify.entities.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class BlogPostDto extends Audit {

    @NotEmpty(message = "blog title must be mandatory")
    private String title;

    private String image;

    @NotEmpty(message = "blog Content must be mandatory")
    private String content;

    private CategoryDto category;

    private UserDto user;

    private CommentDto comment;

}