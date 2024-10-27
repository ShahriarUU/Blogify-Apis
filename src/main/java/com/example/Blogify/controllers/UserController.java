package com.example.Blogify.controllers;

import com.example.Blogify.payloads.UserDto;
import com.example.Blogify.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

@PostMapping("/")
public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
{
    UserDto createUserDto = userService.createUser(userDto);

    return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
}

}
