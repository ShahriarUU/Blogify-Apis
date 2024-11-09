package com.example.Blogify.services;

import com.example.Blogify.payloads.BlogPostDto;

import java.util.List;

public interface BlogPostService {

    BlogPostDto createPostByUser(BlogPostDto blogPostDto,Long userId,Long CategoryId);
    BlogPostDto getPostByUser(Long postId);
    BlogPostDto updatePostByUser(BlogPostDto blogPostDto,Long postId);
    List<BlogPostDto> getAllBlogPost();
    List<BlogPostDto> getAllPostWrittenByUser(Long userId);
    List<BlogPostDto>getAllPostByCategory(Long categoryId);
    void deletePostByUser(Long postId);

}
