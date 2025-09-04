package com.appointment.docter_service.Dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DoctorUpdateDto(
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be blank")
    String email,

    @NotBlank(message = "Phone number cannot be blank")
    String phoneNumber,

    @NotBlank(message = "Address cannot be blank")
    String address
) {}

