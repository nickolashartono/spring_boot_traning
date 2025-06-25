package com.example.testday3.model.request;

import lombok.Data;

@Data
public class ProfileRequest {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
}
