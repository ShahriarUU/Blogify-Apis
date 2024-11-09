package com.example.Blogify.controllers;

import com.example.Blogify.payloads.CommentDto;
import com.example.Blogify.services.CommentService;
import com.example.Blogify.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/user/{userId}/post/{postId}")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,@PathVariable  Long userId,@PathVariable  Long postId)
    {
        CommentDto comment=commentService.createCommentByUser(commentDto,userId,postId);

        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto commentDto,@PathVariable Long commentId)
    {
        CommentDto comment=commentService.updateCommentByUser(commentDto,commentId);
        return new ResponseEntity<>(comment,HttpStatus.OK);
    }

    @DeleteMapping("/{commentId}")
    public  ResponseEntity<?> deleteComment(@PathVariable Long commentId)
    {
        commentService.deleteCommentByUser(commentId);
        return new ResponseEntity<>(new ApiResponse("Comment delete Successfully",true),HttpStatus.OK);
    }
}
