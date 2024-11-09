package com.example.Blogify.services;


import com.example.Blogify.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto registerUser(UserDto user);

    UserDto registerAdmin(UserDto userDto);

    UserDto updateUserInfo(UserDto user, Long userId);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUser();

    void deleteUser(Long userId);

}
