package com.appointment.docter_service.Dtos;

import jakarta.validation.constraints.NotBlank;

public record DoctorAvailabilityDto(
        @NotBlank(message = "Doctor ID cannot be blank")
        String doctorId,

        @NotBlank(message = "availableTimeFrom cannot be blank")
        String availableTimeFrom,

        @NotBlank(message = "availableTimeTo cannot be blank")
        String availableTimeTo,

        @NotBlank(message = "isPresent cannot be blank")
        boolean isPresent
) {
}
