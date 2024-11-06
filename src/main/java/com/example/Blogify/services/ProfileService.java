package com.example.Blogify.services;

import com.example.Blogify.payloads.ProfileDto;

public interface ProfileService {

    ProfileDto createUserProfile(ProfileDto profileDto, Long userId);

    ProfileDto updateProfile(ProfileDto profileDto, Long profileId);

}
