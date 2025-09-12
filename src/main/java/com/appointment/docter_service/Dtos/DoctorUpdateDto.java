package com.appointment.docter_service.Dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DoctorUpdateDto(

        @NotBlank(message = "firstname cannot be blank")
        String firstName,

        @NotBlank(message = "middlename cannot be blank")
        String middleName,

        @NotBlank(message = "lastname cannot be blank")
        String lastName,

        @NotBlank(message = "Phone number cannot be blank")
        String phoneNumber,

        @Email(message = "Email should be valid")
        @NotBlank(message = "Email cannot be blank")
        String email,

        @NotNull(message = "Age cannot be null")
        @Min(value = 1, message = "Age must be at least 1")
        @Max(value = 120, message = "Age must be at most 120")
        Integer age,

        @NotBlank(message = "City cannot be blank")
        String city,

        @NotBlank(message = "State cannot be blank")
        String state,

        @NotBlank(message = "Zip code cannot be blank")
        String zipCode,

        @NotBlank(message = "Address cannot be blank")
        String address
) {
}
