package com.example.Blogify.controllers;

import com.example.Blogify.payloads.BlogPostDto;
import com.example.Blogify.payloads.UserDto;
import com.example.Blogify.services.BlogPostService;
import com.example.Blogify.services.UserService;
import com.example.Blogify.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/me")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto createUserDto = userService.registerUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    @PostMapping("/admin")
    public ResponseEntity<UserDto> createAdmin(@Valid @RequestBody UserDto userDto)
    {
        UserDto createAdminDto=userService.registerAdmin(userDto);
        return new ResponseEntity<>(createAdminDto, HttpStatus.CREATED);

    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser( @RequestBody UserDto userDto, @PathVariable Long userId) {

        UserDto updateUserDto = userService.updateUserInfo(userDto, userId);
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




}

