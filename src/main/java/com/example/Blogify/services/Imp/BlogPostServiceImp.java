package com.example.Blogify.services.Imp;

import com.example.Blogify.entities.BlogPost;
import com.example.Blogify.payloads.BlogPostDto;
import com.example.Blogify.repositories.BlogPostRepo;
import com.example.Blogify.services.BlogPostService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogPostServiceImp implements BlogPostService {


    @Autowired
    private BlogPostRepo blogPostRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public BlogPostDto createPost(BlogPostDto blogPostDto) {

       BlogPost blogPost=modelMapper.map(blogPostDto,BlogPost.class);

       return modelMapper.map(blogPostRepo.save(blogPost),BlogPostDto.class);

    }

}
