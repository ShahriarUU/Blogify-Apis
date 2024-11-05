package com.example.Blogify.controllers;

import com.example.Blogify.payloads.ProfileDto;
import com.example.Blogify.services.Imp.ProfileServiceImp;
import com.example.Blogify.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("/{userId}")
    public ResponseEntity<ProfileDto> createProfile(@RequestBody ProfileDto profile, @PathVariable Integer userId) {
        ProfileDto createProfile = profileService.createUserProfile(profile, userId);

        return new ResponseEntity<>(createProfile, HttpStatus.CREATED);
    }

    @PutMapping("/{profileId}")
    public ResponseEntity<ProfileDto> updateProfile(@RequestBody ProfileDto profile, @PathVariable Integer profileId) {
        ProfileDto updateProfile = profileService.updateProfile(profile, profileId);

        return new ResponseEntity<>(updateProfile, HttpStatus.OK);
    }
}
