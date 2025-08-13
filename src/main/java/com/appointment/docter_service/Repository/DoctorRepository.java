package com.appointment.docter_service.Repository;

import com.appointment.docter_service.Entities.DoctorRegisterEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository extends MongoRepository<DoctorRegisterEntity, String> {

    // Method to find a doctor by username
    DoctorRegisterEntity findByUsername(String username);

    // Method to find a doctor by email
    DoctorRegisterEntity findByEmail(String email);

    // Method to check if a username already exists
    boolean existsByUsername(String username);

    // Method to check if an email already exists
    boolean existsByEmail(String email);
}
