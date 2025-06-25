package com.example.testday3.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.testday3.model.request.ProfileRequest;
import com.example.testday3.model.response.ProfileResponse;
import com.example.testday3.service.ProfileService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @PostMapping("/profile")
    public ResponseEntity<ProfileResponse> saveProfile(@RequestBody ProfileRequest profileRequest) {
        return ResponseEntity.ok(profileService.saveProfile(profileRequest));
    }
    
    @GetMapping("/profile")
    public ResponseEntity<List<ProfileResponse>> getAllProfiles(@RequestBody ProfileRequest profileRequest) {
        return ResponseEntity.ok(profileService.getAllProfiles());
    }
}
