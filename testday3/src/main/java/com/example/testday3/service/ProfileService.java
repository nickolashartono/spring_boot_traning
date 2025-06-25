package com.example.testday3.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.testday3.model.Profile;
import com.example.testday3.model.request.ProfileRequest;
import com.example.testday3.model.response.ProfileResponse;
import com.example.testday3.repository.ProfileRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileResponse saveProfile(ProfileRequest request) {
        Profile profile = Profile.builder()
                            .fullName(request.getFullName())
                            .email(request.getEmail())
                            .phone(request.getPhoneNumber())
                            .address(request.getAddress())
                            .build();

        profileRepository.save(profile);
        
        return ProfileResponse.builder()
                .fullName(profile.getFullName())
                .email(profile.getEmail())
                .phoneNumber(profile.getPhone()).build();
    }

    public List<ProfileResponse> getAllProfiles() {
        return (List<ProfileResponse>) profileRepository.findAll().stream().map(x -> {
            return ProfileResponse.builder()
                                    .fullName(x.getFullName())
                                    .email(x.getEmail())
                                    .phoneNumber(x.getPhone()).build();
        }).toList();
    }
}
