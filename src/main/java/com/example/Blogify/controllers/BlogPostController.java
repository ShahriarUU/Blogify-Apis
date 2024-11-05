package com.example.Blogify.controllers;


import com.example.Blogify.payloads.BlogPostDto;
import com.example.Blogify.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user/blog-post")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPost;

    @PostMapping("/")
    public ResponseEntity<BlogPostDto> createPost(BlogPostDto blogPostDto)
    {
      BlogPostDto createPost= blogPost.createPost(blogPostDto);

      return new ResponseEntity<>(createPost, HttpStatus.CREATED);
    }

}
