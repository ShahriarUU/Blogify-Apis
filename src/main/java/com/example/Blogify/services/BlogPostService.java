package com.example.Blogify.services;

import com.example.Blogify.payloads.BlogPostDto;

public interface BlogPostService {

    BlogPostDto createPost(BlogPostDto blogPostDto);
}
