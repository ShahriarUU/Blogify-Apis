package com.example.Blogify.controllers;

import com.example.Blogify.payloads.BlogPostDto;
import com.example.Blogify.payloads.UserDto;
import com.example.Blogify.services.UserService;
import com.example.Blogify.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto createUserDto = userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser( @RequestBody UserDto userDto, @PathVariable Long userId) {

        UserDto updateUserDto = userService.updateUser(userDto, userId);
        return new ResponseEntity<>(updateUserDto, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long userId) {
        UserDto userDto = userService.getUserById(userId);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUser() {
        List<UserDto> allUser = userService.getAllUser();
        return new ResponseEntity<>(allUser, HttpStatus.OK);
    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(new ApiResponse("User delete successfully", true), HttpStatus.OK);
    }

    @GetMapping("/all-blog-posts/{userId}")
    public ResponseEntity<List<BlogPostDto>> getAllBlogPosts(@PathVariable Long userId)
    {
       List<BlogPostDto> allPosts= userService.getAllPostWriteByUser(userId);
       return  new ResponseEntity<>(allPosts,HttpStatus.OK);
    }
}

