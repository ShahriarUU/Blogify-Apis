package com.example.Blogify.controllers;


import com.example.Blogify.payloads.BlogPostDto;
import com.example.Blogify.services.BlogPostService;
import com.example.Blogify.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @PostMapping("/user/{userId}/category/{categoryId}")
    public ResponseEntity<BlogPostDto> createPost(@RequestBody BlogPostDto blogPostDto,@PathVariable Long userId,@PathVariable Long categoryId)
    {
      BlogPostDto createPost= blogPostService.createPostByUser(blogPostDto,userId,categoryId);

      return new ResponseEntity<>(createPost, HttpStatus.CREATED);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<BlogPostDto> updatePost(@RequestBody BlogPostDto blogPostDto,@PathVariable Long postId)
    {
        BlogPostDto updatedPost=blogPostService.updatePostByUser(blogPostDto,postId);

        return new ResponseEntity<>(updatedPost,HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<BlogPostDto>getPost(@PathVariable Long postId)
    {
        BlogPostDto blogPost=blogPostService.getPostByUser(postId);
        return new ResponseEntity<>(blogPost,HttpStatus.OK);
    }


    @DeleteMapping("/{postId}")
    public ResponseEntity<?>deletePost(@PathVariable Long postId)
    {
        blogPostService.deletePostByUser(postId);
        return new ResponseEntity<>(new ApiResponse("Blog post delete successfully", true), HttpStatus.OK);

    }

    @GetMapping("/")
    public ResponseEntity<List<BlogPostDto>> getAllBlogPost()
    {
         List<BlogPostDto> allBlogPost = blogPostService.getAllBlogPost();
         return new ResponseEntity<>(allBlogPost,HttpStatus.OK);

    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BlogPostDto>> getAllBlogPostWrittenByUser(@PathVariable Long userId)
    {
        List<BlogPostDto> blogPostByUser = blogPostService.getAllPostWrittenByUser(userId);
        return new ResponseEntity<>(blogPostByUser,HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}")
    public  ResponseEntity<List<BlogPostDto>> getAllBlogPost(@PathVariable Long categoryId)
    {
        List<BlogPostDto> blogPostByCategory=blogPostService.getAllPostByCategory(categoryId);
        return new ResponseEntity<>(blogPostByCategory,HttpStatus.OK);
    }
//git learing 01add
}
