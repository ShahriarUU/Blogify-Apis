package com.example.Blogify.services.Imp;

import com.example.Blogify.entities.Profile;
import com.example.Blogify.entities.User;
import com.example.Blogify.exceptions.ResourceNotFoundException;
import com.example.Blogify.payloads.ProfileDto;
import com.example.Blogify.repositories.ProfileRepo;
import com.example.Blogify.repositories.UserRepo;
import com.example.Blogify.services.ProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImp implements ProfileService {

    @Autowired
    private ProfileRepo profileRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Override
    public ProfileDto createUserProfile(ProfileDto profileDto, Integer userId) {

        Profile userProfile = modelMapper.map(profileDto, Profile.class);

        Profile createProfile = profileRepo.save(userProfile);

        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));

        user.setProfile(createProfile);
        userRepo.save(user);

        return modelMapper.map(createProfile, ProfileDto.class);

    }

    @Override
    public ProfileDto updateProfile(ProfileDto profileDto, Integer profileId) {

        Profile profile = profileRepo.findById(profileId).orElseThrow(() -> new ResourceNotFoundException("Profile", "Id", profileId));

        profile.setName(profileDto.getName() != null ? profileDto.getName() : profile.getName());
        profile.setImage(profileDto.getImage() != null ? profileDto.getImage() : profile.getImage());
        profile.setAddress(profileDto.getAddress() != null ? profileDto.getAddress() : profile.getAddress());
        profile.setAbout(profileDto.getAbout() != null ? profileDto.getAbout() : profile.getAbout());
        profile.setPhoneNumber(profileDto.getPhoneNumber() != null ? profileDto.getPhoneNumber() : profile.getPhoneNumber());
        profile.setProfession(profileDto.getProfession() != null ? profileDto.getProfession() : profile.getProfession());

        Profile updateProfile = profileRepo.save(profile);

        return modelMapper.map(updateProfile, ProfileDto.class);
    }


}
