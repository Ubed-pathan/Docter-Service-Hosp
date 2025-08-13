package com.appointment.docter_service.Dtos;

import jakarta.validation.constraints.*;

public record DoctorRegisterDto(

        @NotBlank(message = "First name is required")
        String firstName,

        String middleName,

        @NotBlank(message = "Last name is required")
        String lastName,

        @NotBlank(message = "Username is required")
        @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
        String username,

        @NotBlank(message = "Email is required")
        @Email(message = "Email should be valid")
        String email,

        @NotBlank(message = "Phone number is required")
        @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
        String phoneNumber,

        @NotBlank(message = "Gender is required")
        String gender,

        @NotBlank(message = "Specialization is required")
        String specialization,

        @Min(value = 0, message = "Experience must be non-negative")
        int experienceYears,

        @NotBlank(message = "Qualification is required")
        String qualification,

        @NotBlank(message = "License number is required")
        String licenseNumber,

        @NotBlank(message = "Hospital name is required")
        String hospitalName,

        @NotBlank(message = "Hospital address is required")
        String hospitalAddress,

        @NotBlank(message = "Available time from is required")
        String availableTimeFrom,

        @NotBlank(message = "Available time to is required")
        String availableTimeTo,

        @NotBlank(message = "City is required")
        String city,

        @NotBlank(message = "State is required")
        String state,

        @NotBlank(message = "Country is required")
        String country,

        @NotBlank(message = "Zip code is required")
        String zipCode,

        @NotBlank(message = "Password is required")
        @Size(min = 6, message = "Password must be at least 6 characters")
        String password,

        @NotNull(message = "Presence status is required")
        Boolean isPresent

) {}
