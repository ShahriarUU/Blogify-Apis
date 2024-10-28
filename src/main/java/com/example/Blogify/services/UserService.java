package com.example.Blogify.services;

import com.example.Blogify.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user, Integer userId);

    UserDto getUserById(Integer userId);

    List<UserDto> getAllUser();

    void deleteUser(Integer userId);
}
