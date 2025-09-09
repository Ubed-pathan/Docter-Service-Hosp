package com.appointment.docter_service.Dtos;

public record DoctorByUsernameDto(
        String id,
        String username,
        String firstName,
        String lastName,
        String specialization,
        Boolean isPresent,
        String availableTimeFrom,
        String availableTimeTo,
        double rating,
        int reviewCount
) {}

