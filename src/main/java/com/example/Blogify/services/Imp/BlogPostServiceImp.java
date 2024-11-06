package com.example.Blogify.services.Imp;

import com.example.Blogify.entities.BlogPost;
import com.example.Blogify.entities.Category;
import com.example.Blogify.entities.User;
import com.example.Blogify.exceptions.ResourceNotFoundException;
import com.example.Blogify.payloads.BlogPostDto;
import com.example.Blogify.payloads.ProfileDto;
import com.example.Blogify.payloads.UserDto;
import com.example.Blogify.repositories.BlogPostRepo;
import com.example.Blogify.repositories.CategoryRepo;
import com.example.Blogify.repositories.UserRepo;
import com.example.Blogify.services.BlogPostService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogPostServiceImp implements BlogPostService {


    @Autowired
    private BlogPostRepo blogPostRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Transactional
    @Override
    public BlogPostDto createPost(BlogPostDto blogPostDto,Long userId, Long categoryId) {
        BlogPost blogPost = dtoToPost(blogPostDto);
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
        blogPost.setProfile(user.getProfile());
        blogPost.setCategory(category);
        BlogPost createBlog=blogPostRepo.save(blogPost);
        return postToDto(createBlog);
    }

    @Override
    public BlogPostDto getPost(Long postId) {
        BlogPost blogPost = blogPostRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));
        return postToDto(blogPost);
    }

    @Transactional
    @Override
    public BlogPostDto updatePost(BlogPostDto blogPostDto, Long postId) {
        BlogPost blogPost = blogPostRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "Id", postId));
        blogPost.setTitle(blogPostDto.getTitle() != null ? blogPostDto.getTitle() : blogPost.getTitle());
        blogPost.setImage(blogPostDto.getImage() != null ? blogPostDto.getImage() : blogPost.getImage());
        blogPost.setContent(blogPostDto.getContent() != null ? blogPostDto.getContent() : blogPost.getContent());

        BlogPost updatedPost = blogPostRepo.save(blogPost);
        return postToDto(updatedPost);
    }

    @Override
    public List<BlogPostDto> getAllPost() {

        return blogPostRepo.findAll().stream().map(this::postToDto).collect(Collectors.toList());

    }

    @Transactional
    @Override
    public void deletePost(Long postId) {
        BlogPost blogPost = blogPostRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));
        blogPostRepo.delete(blogPost);
    }


    public BlogPostDto postToDto(BlogPost blogPost) {

        BlogPostDto blogPostDto = modelMapper.map(blogPost, BlogPostDto.class);
        if (blogPostDto.getProfile() != null)
            blogPostDto.setProfile(modelMapper.map(blogPost.getProfile(), ProfileDto.class));

        return blogPostDto;
    }

    private BlogPost dtoToPost(BlogPostDto blogPostDto) {
        return modelMapper.map(blogPostDto, BlogPost.class);
    }

}
