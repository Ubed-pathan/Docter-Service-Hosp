package com.appointment.docter_service.Dtos;

import jakarta.validation.constraints.NotBlank;

public record GetAllDoctorDto(
        String doctorId,
        String doctorFullName,
        String specialization,
        String qualification,
        int experienceYears,
        String hospitalName,
        String hospitalAddress,
        String availableTimeFrom,
        String availableTimeTo,
        String city,
        String state,
        String country,
        String profileImageUrl,
        String department,
        double rating,
        int reviewCount
) {}