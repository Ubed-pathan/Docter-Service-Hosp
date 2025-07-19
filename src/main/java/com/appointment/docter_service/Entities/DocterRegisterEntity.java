package com.appointment.docter_service.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocterRegisterEntity {

    @Id
    private String id;

    private String firstName;
    private String middleName;
    private String lastName;

    @Indexed(unique = true)
    @NonNull
    private String username;

    @Indexed(unique = true)
    @NonNull
    private String email;

    @Indexed(unique = true)
    @NonNull
    private String phoneNumber;

    private String gender;
    private String specialization;

    private int experienceYears;

    @NonNull
    private String qualification;

    @Indexed(unique = true)
    private String licenseNumber;

    private String hospitalName;
    private String hospitalAddress;

    private List<String> availableDays;
    private String availableTimeFrom;
    private String availableTimeTo;

    private String city;
    private String state;
    private String country;
    private String zipCode;

    private String password;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime lastModified;
}

