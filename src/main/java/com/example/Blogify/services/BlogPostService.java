package com.example.Blogify.services;

import com.example.Blogify.payloads.BlogPostDto;

import java.util.List;

public interface BlogPostService {

    BlogPostDto createPost(BlogPostDto blogPostDto,Long userId,Long CategoryId);
    BlogPostDto getPost(Long postId);
    BlogPostDto updatePost(BlogPostDto blogPostDto,Long postId);
    List<BlogPostDto> getAllPost();
    void deletePost(Long postId);

}
