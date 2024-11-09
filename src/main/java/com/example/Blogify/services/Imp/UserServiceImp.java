package com.example.Blogify.services.Imp;


import com.example.Blogify.entities.Enums.UserRole;
import com.example.Blogify.entities.User;
import com.example.Blogify.exceptions.ResourceNotFoundException;
import com.example.Blogify.payloads.BlogPostDto;
import com.example.Blogify.payloads.ProfileDto;
import com.example.Blogify.payloads.UserDto;
import com.example.Blogify.repositories.BlogPostRepo;
import com.example.Blogify.repositories.UserRepo;
import com.example.Blogify.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.Blogify.entities.Enums.UserRole.USER;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BlogPostRepo blogPostRepo;
    @Autowired
    private BlogPostServiceImp blogPostServiceImp;


    @Transactional
    @Override
    public UserDto registerUser(UserDto userDto) {

        User user = dtoToUser(userDto);
        user.setRole(UserRole.USER);
        User savedUser = userRepo.save(user);
        return userToDto(savedUser);
    }

    @Transactional
    @Override
    public UserDto registerAdmin(UserDto userDto) {
        User user = dtoToUser(userDto);
        user.setRole(UserRole.ADMIN);
        User savedUser = userRepo.save(user);
        return userToDto(savedUser);
    }

    @Transactional
    @Override
    public UserDto updateUserInfo(UserDto userDto, Long userId) {

        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        user.setEmail(userDto.getEmail() != null ? userDto.getEmail() : user.getEmail());
        user.setPassword(userDto.getPassword() != null ? userDto.getPassword() : user.getPassword());
        User updatedUser = userRepo.save(user);

        return userToDto(updatedUser);

    }

    @Override
    public UserDto getUserById(Long userId) {

        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {

        List<User> users = userRepo.findAll();
        return users.stream().map(this::userToDto).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteUser(Long userId) {

        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

        userRepo.delete(user);
    }




    private User dtoToUser(UserDto userDto) {

        return modelMapper.map(userDto, User.class);
    }

    private UserDto userToDto(User user) {

        UserDto userDto = modelMapper.map(user, UserDto.class);
        if (user.getProfile() != null)
            userDto.setProfile(modelMapper.map(user.getProfile(), ProfileDto.class));

        return userDto;
    }
}
