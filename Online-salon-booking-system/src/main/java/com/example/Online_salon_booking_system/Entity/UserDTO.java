package com.example.Online_salon_booking_system.Entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserDTO {
    @NotBlank
    private String name;
    @Email
    private String email;
    @NotBlank
    private String password;
    @NotNull
    private Role role;
}
