package com.appointment.docter_service.Repository;

import com.appointment.docter_service.Entities.DocterRegisterEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocterRegisterRepository extends MongoRepository<DocterRegisterEntity, String> {

    // Method to find a doctor by username
    DocterRegisterEntity findByUsername(String username);

    // Method to find a doctor by email
    DocterRegisterEntity findByEmail(String email);

    // Method to check if a username already exists
    boolean existsByUsername(String username);

    // Method to check if an email already exists
    boolean existsByEmail(String email);
}
