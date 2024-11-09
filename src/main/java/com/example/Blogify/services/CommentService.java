package com.example.Blogify.services;

import com.example.Blogify.entities.BlogPost;
import com.example.Blogify.entities.Comment;
import com.example.Blogify.entities.User;
import com.example.Blogify.payloads.CommentDto;

public interface CommentService {

    CommentDto createCommentByUser(CommentDto commentDto, Long userId, Long postId);

    CommentDto updateCommentByUser(CommentDto commentDto,Long commentId);

    void deleteCommentByUser(Long commentId );
}
