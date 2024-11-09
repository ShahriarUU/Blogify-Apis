package com.example.Blogify.services;

import com.example.Blogify.payloads.ProfileDto;

public interface ProfileService {

    ProfileDto createProfileByUser(ProfileDto profileDto, Long userId);

    ProfileDto updateProfileByUser(ProfileDto profileDto, Long profileId);

}
