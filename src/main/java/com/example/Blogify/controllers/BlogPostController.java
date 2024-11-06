package com.example.Blogify.controllers;


import com.example.Blogify.payloads.BlogPostDto;
import com.example.Blogify.services.BlogPostService;
import com.example.Blogify.utils.ApiResponse;
import lombok.Generated;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user/post")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @PostMapping("/{userId}/{categoryId}")
    public ResponseEntity<BlogPostDto> createPost(@RequestBody BlogPostDto blogPostDto,@PathVariable Long userId,@PathVariable Long categoryId)
    {
      BlogPostDto createPost= blogPostService.createPost(blogPostDto,userId,categoryId);

      return new ResponseEntity<>(createPost, HttpStatus.CREATED);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<BlogPostDto> updatePost(@RequestBody BlogPostDto blogPostDto,@PathVariable Long postId)
    {
        BlogPostDto updatedPost=blogPostService.updatePost(blogPostDto,postId);

        return new ResponseEntity<>(updatedPost,HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<BlogPostDto>getPost(@PathVariable Long postId)
    {
        BlogPostDto blogPost=blogPostService.getPost(postId);
        return new ResponseEntity<>(blogPost,HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<BlogPostDto>> getAllBlogPost()
    {
        List<BlogPostDto> blogPostList=blogPostService.getAllPost();
        return new ResponseEntity<>(blogPostList,HttpStatus.OK);
    }
    @DeleteMapping("/{postId}")
    public ResponseEntity<?>deletePost(@PathVariable Long postId)
    {
        blogPostService.deletePost(postId);
        return new ResponseEntity<>(new ApiResponse("post delete successfully", true), HttpStatus.OK);

    }

}
