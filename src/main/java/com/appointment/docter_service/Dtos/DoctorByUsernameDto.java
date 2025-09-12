package com.appointment.docter_service.Dtos;

import java.time.LocalDateTime;

public record DoctorByUsernameDto(
        String id,
        String username,
        String firstName,
        String middleName,
        String lastName,
        int age,
        String gender,
        String email,
        String phoneNumber,
        String specialization,
        String qualification,
        int experienceYears,
        String doctorAddress,
        String city,
        String state,
        String country,
        String zipCode,
        Boolean isPresent,
        String availableTimeFrom,
        String availableTimeTo,
        double rating,
        int reviewCount,
        LocalDateTime joinedDate
) {}

