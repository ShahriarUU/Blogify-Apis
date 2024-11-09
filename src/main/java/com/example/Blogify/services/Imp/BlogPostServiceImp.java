package com.example.Blogify.services.Imp;

import com.example.Blogify.entities.BlogPost;
import com.example.Blogify.entities.Category;
import com.example.Blogify.entities.Comment;
import com.example.Blogify.entities.User;
import com.example.Blogify.exceptions.ResourceNotFoundException;
import com.example.Blogify.payloads.BlogPostDto;
import com.example.Blogify.payloads.CommentDto;
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
    public BlogPostDto createPostByUser(BlogPostDto blogPostDto,Long userId, Long categoryId) {
        BlogPost blogPost = dtoToPost(blogPostDto);
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
        blogPost.setUser(user);
        blogPost.setCategory(category);
        BlogPost createBlog=blogPostRepo.save(blogPost);
        return postToDto(createBlog);
    }



    @Override
    public BlogPostDto getPostByUser(Long postId) {
        BlogPost blogPost = blogPostRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));
        return postToDto(blogPost);
    }

    @Transactional
    @Override
    public BlogPostDto updatePostByUser(BlogPostDto blogPostDto, Long postId) {

        BlogPost blogPost = blogPostRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "Id", postId));
        blogPost.setTitle(blogPostDto.getTitle() != null ? blogPostDto.getTitle() : blogPost.getTitle());
        blogPost.setImage(blogPostDto.getImage() != null ? blogPostDto.getImage() : blogPost.getImage());
        blogPost.setContent(blogPostDto.getContent() != null ? blogPostDto.getContent() : blogPost.getContent());

        BlogPost updatedPost = blogPostRepo.save(blogPost);
        return postToDto(updatedPost);
    }

    @Override
    public List<BlogPostDto> getAllBlogPost() {
        return blogPostRepo.findAll().stream().map(this::postToDto).collect(Collectors.toList());
    }

    @Override
    public List<BlogPostDto> getAllPostWrittenByUser(Long userId) {

      User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
      return blogPostRepo.findByUser(user).stream().map(this::postToDto).collect(Collectors.toList());

    }

    @Override
    public List<BlogPostDto> getAllPostByCategory(Long categoryId) {
        Category category=categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","id",categoryId));

        return blogPostRepo.findByCategory(category).stream().map(this::postToDto).collect(Collectors.toList());
    }


    @Transactional
    @Override
    public void deletePostByUser(Long postId) {
        BlogPost blogPost = blogPostRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));
        blogPostRepo.delete(blogPost);
    }


    private  BlogPostDto postToDto(BlogPost blogPost) {

        BlogPostDto blogPostDto = modelMapper.map(blogPost, BlogPostDto.class);
        if (blogPostDto.getUser() != null || blogPostDto.getComment() != null) {
            blogPostDto.setUser(modelMapper.map(blogPost.getUser(), UserDto.class));
           List<CommentDto> commentDto= blogPost.getComment().stream().map((comment)->modelMapper.map(comment,CommentDto.class)).collect(Collectors.toList());
           blogPostDto.setComment(commentDto);
           return blogPostDto;
        }
        return modelMapper.map(blogPost,BlogPostDto.class);
    }

    private BlogPost dtoToPost(BlogPostDto blogPostDto) {
        return modelMapper.map(blogPostDto,BlogPost.class);
    }


    }
