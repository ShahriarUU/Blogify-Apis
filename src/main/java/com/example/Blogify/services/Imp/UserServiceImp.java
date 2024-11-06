package com.example.Blogify.services.Imp;

import com.example.Blogify.entities.BlogPost;
import com.example.Blogify.entities.Profile;
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

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = dtoToUser(userDto);
        User savedUser = userRepo.save(user);
        return userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long userId) {

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

    @Override
    public void deleteUser(Long userId) {

        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

        userRepo.delete(user);
    }

    @Override
    public List<BlogPostDto> getAllPostWriteByUser(Long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        Long profileId = user.getProfile().getId();
        return blogPostRepo.findByProfileId(profileId).stream().map((post) -> blogPostServiceImp.postToDto(post)).collect(Collectors.toList());

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
