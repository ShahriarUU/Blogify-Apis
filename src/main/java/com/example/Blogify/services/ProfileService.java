package com.example.Blogify.services;

import com.example.Blogify.payloads.ProfileDto;

public interface ProfileService {

    ProfileDto createUserProfile(ProfileDto profileDto, Integer userId);

    ProfileDto updateProfile(ProfileDto profileDto, Integer profileId);

}
