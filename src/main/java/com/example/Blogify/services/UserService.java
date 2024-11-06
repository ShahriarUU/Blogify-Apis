package com.example.Blogify.services;

import com.example.Blogify.entities.BlogPost;
import com.example.Blogify.payloads.BlogPostDto;
import com.example.Blogify.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user, Long userId);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUser();

    void deleteUser(Long userId);

    List<BlogPostDto> getAllPostWriteByUser(Long userId);
}
