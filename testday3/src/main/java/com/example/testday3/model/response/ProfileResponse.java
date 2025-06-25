package com.example.testday3.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfileResponse {
    private String fullName;
    private String email;
    private String phoneNumber;
}
