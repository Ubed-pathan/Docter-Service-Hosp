package com.appointment.docter_service.Dtos;

import jakarta.validation.constraints.*;

public record DoctorAvailabilityDto(
        @NotBlank(message = "Doctor ID cannot be blank")
        String DoctorUsername,

        @NotBlank(message = "availableTimeFrom cannot be blank")
        String availableTimeFrom,

        @NotBlank(message = "availableTimeTo cannot be blank")
        String availableTimeTo,

        @NotNull(message = "isPresent is required")
        Boolean isPresent
) {
}
