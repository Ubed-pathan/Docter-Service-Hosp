package com.appointment.docter_service.Dtos;

public record AppointmentDoctorDto(
        String doctorUsername,
        String doctorsFullName,
        String doctorSpecialization
) {
}
