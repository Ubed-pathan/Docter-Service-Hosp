package com.appointment.docter_service.Service;

import com.appointment.docter_service.Dtos.DocterRegisterDto;
import com.appointment.docter_service.Entities.DocterRegisterEntity;
import com.appointment.docter_service.Repository.DocterRegisterRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DocterRegisterService {
    
        private DocterRegisterRepository docterRegisterRepository;
        private PasswordEncoder passwordEncoder;


    public void register(@Valid DocterRegisterDto dto) {
        if (docterRegisterRepository.existsByUsername(dto.username())) {
            throw new IllegalArgumentException("Username already exists.");
        }

        DocterRegisterEntity docterRegisterEntity = new DocterRegisterEntity();
        docterRegisterEntity.setUsername(dto.username());
        docterRegisterEntity.setEmail(dto.email());
        docterRegisterEntity.setPhoneNumber(dto.phoneNumber());
        docterRegisterEntity.setPassword(passwordEncoder.encode(dto.password()));
        docterRegisterEntity.setFirstName(dto.firstName());
        docterRegisterEntity.setMiddleName(dto.middleName());
        docterRegisterEntity.setLastName(dto.lastName());
        docterRegisterEntity.setSpecialization(dto.specialization());
        docterRegisterEntity.setExperienceYears(dto.experienceYears());
        docterRegisterEntity.setCity(dto.city());
        docterRegisterEntity.setState(dto.state());
        docterRegisterEntity.setCountry(dto.country());
        docterRegisterEntity.setZipCode(dto.zipCode());
        docterRegisterEntity.setLicenseNumber(dto.licenseNumber());
        docterRegisterEntity.setHospitalName(dto.hospitalName());
        docterRegisterEntity.setHospitalAddress(dto.hospitalAddress());
        docterRegisterEntity.setAvailableTimeFrom(dto.availableTimeFrom());
        docterRegisterEntity.setAvailableTimeTo(dto.availableTimeTo());;
        docterRegisterEntity.setGender(dto.gender());
        docterRegisterEntity.setQualification(dto.qualification());
        docterRegisterEntity.setCreatedAt(java.time.LocalDateTime.now());
        docterRegisterEntity.setLastModified(java.time.LocalDateTime.now());
        docterRegisterRepository.save(docterRegisterEntity);

    }

    public boolean isDocterExists(String docterId) {
        if (docterId == null || docterId.isEmpty()) {
            throw new IllegalArgumentException("Doctor ID cannot be null or empty.");
        }
        return docterRegisterRepository.existsById(docterId);

    }
}
