package com.example.Blogify.services.Imp;

import com.example.Blogify.entities.BlogPost;
import com.example.Blogify.entities.Comment;
import com.example.Blogify.entities.User;
import com.example.Blogify.exceptions.ResourceNotFoundException;
import com.example.Blogify.payloads.CommentDto;
import com.example.Blogify.repositories.BlogPostRepo;
import com.example.Blogify.repositories.CommentRepo;
import com.example.Blogify.repositories.UserRepo;
import com.example.Blogify.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentServiceImp implements CommentService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BlogPostRepo blogPostRepo;

    @Transactional
    @Override
    public CommentDto createCommentByUser(CommentDto commentDto,Long userId, Long postId) {
      Comment comment=modelMapper.map(commentDto,Comment.class);
      User user= userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
      BlogPost blogPost=blogPostRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Blog post","id",postId));
      comment.setUser(user);
      comment.setBlogPost(blogPost);
      return modelMapper.map(commentRepo.save(comment),CommentDto.class);
    }

    @Transactional
    @Override
    public CommentDto updateCommentByUser(CommentDto commentDto,Long commentId) {
       Comment comment=commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment","id",commentId));
       comment.setContent(commentDto.getContent()!=null?commentDto.getContent():comment.getContent());
        return modelMapper.map(commentRepo.save(comment),CommentDto.class);

    }

    @Transactional
    @Override
    public void deleteCommentByUser(Long commentId) {
        Comment comment=commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment","id",commentId));
        commentRepo.delete(comment);
    }
}
