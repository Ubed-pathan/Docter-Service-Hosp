    package com.appointment.docter_service.Entities;
    
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    import lombok.NonNull;
    import org.springframework.data.annotation.Id;
    import org.springframework.data.mongodb.core.index.Indexed;
    import org.springframework.data.mongodb.core.mapping.Document;
    import java.time.LocalDateTime;
    
    @Document(collection = "doctor_register")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class DoctorRegisterEntity {
    
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
    
        private String doctorAddress;
        private int age;
    
        private String availableTimeFrom;
        private String availableTimeTo;
    
        private String city;
        private String state;
        private String country;
        private String zipCode;
    
        private String password;
    
        private double rating;
        private int reviewCount;
    
        private Boolean isPresent = true;
    
        private LocalDateTime createdAt;
    
        private LocalDateTime lastModified;
    }
