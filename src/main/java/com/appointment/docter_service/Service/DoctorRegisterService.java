package com.appointment.docter_service.Service;

import com.appointment.docter_service.Dtos.DoctorRegisterDto;
import com.appointment.docter_service.Dtos.GetAllDoctorDto;
import com.appointment.docter_service.Dtos.UserRegistrationDto;
import com.appointment.docter_service.Entities.DoctorRegisterEntity;
import com.appointment.docter_service.Repository.DoctorRepository;
import com.appointment.docter_service.clients.UserClient;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorRegisterService {
    private final DoctorRepository doctorRegisterRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserClient userClient;


    public void register(@Valid DoctorRegisterDto dto) {
        try {
            if (doctorRegisterRepository.existsByUsername(dto.username())) {
                throw new IllegalArgumentException("Username already exists.");
            }

            DoctorRegisterEntity docterRegisterEntity = new DoctorRegisterEntity();
            docterRegisterEntity.setUsername(dto.username());
            docterRegisterEntity.setEmail(dto.email());
            docterRegisterEntity.setPhoneNumber(dto.phoneNumber());
            docterRegisterEntity.setPassword(passwordEncoder.encode(dto.password()));
            docterRegisterEntity.setFirstName(dto.firstName());
            docterRegisterEntity.setMiddleName(dto.middleName());
            docterRegisterEntity.setLastName(dto.lastName());
            docterRegisterEntity.setDoctorAddress(dto.doctorAddress());
            docterRegisterEntity.setAge(dto.age());
            docterRegisterEntity.setSpecialization(dto.specialization());
            docterRegisterEntity.setExperienceYears(dto.experienceYears());
            docterRegisterEntity.setCity(dto.city());
            docterRegisterEntity.setState(dto.state());
            docterRegisterEntity.setCountry(dto.country());
            docterRegisterEntity.setZipCode(dto.zipCode());
            docterRegisterEntity.setLicenseNumber(dto.licenseNumber());
            docterRegisterEntity.setAvailableTimeFrom(dto.availableTimeFrom());
            docterRegisterEntity.setAvailableTimeTo(dto.availableTimeTo());
            docterRegisterEntity.setGender(dto.gender());
            docterRegisterEntity.setQualification(dto.qualification());
            docterRegisterEntity.setCreatedAt(java.time.LocalDateTime.now());
            docterRegisterEntity.setLastModified(java.time.LocalDateTime.now());
            doctorRegisterRepository.save(docterRegisterEntity);

            UserRegistrationDto user = new UserRegistrationDto(
                    dto.firstName(),
                    dto.middleName(),
                    dto.lastName(),
                    dto.username(),
                    dto.email(),
                    dto.password(),
                    dto.age(),
                    dto.phoneNumber(),
                    dto.doctorAddress(),
                    dto.city(),
                    dto.state(),
                    dto.country(),
                    dto.zipCode()
                    );

            userClient.registerUser(user);
        }
        catch (Exception e) {
            e.printStackTrace();
        }



    }

    public String getDoctorName(String doctorId) {
        if (doctorId == null || doctorId.isEmpty()) {
            throw new IllegalArgumentException("Doctor ID cannot be null or empty.");
        }

        return doctorRegisterRepository.findById(doctorId)
                .map(doc -> doc.getFirstName() +
                        (doc.getMiddleName() != null ? " " + doc.getMiddleName() : "") +
                        " " + doc.getLastName())
                .orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + doctorId));
    }

    public List<DoctorRegisterEntity> getAllDoctors() {
        List<DoctorRegisterEntity> doctors = doctorRegisterRepository.findAll();
        if (doctors.isEmpty()) {
            throw new RuntimeException("No doctors found.");
        }

        List<GetAllDoctorDto> doctorDtos = doctors.stream().map(doc -> new GetAllDoctorDto(
                doc.getId(),
                doc.getFirstName() + (doc.getMiddleName() != null ? " " + doc.getMiddleName() : "") + " " + doc.getLastName(),
                doc.getSpecialization(),
                doc.getQualification(),
                doc.getExperienceYears(),
                doc.getAvailableTimeFrom(),
                doc.getAvailableTimeTo(),
                doc.getCity(),
                doc.getState(),
                doc.getCountry(),
                "", // Assuming profileImageUrl is not stored in DoctorRegisterEntity
                "", // Assuming department is not stored in DoctorRegisterEntity
                doc.getRating(),
                doc.getReviewCount()
        )).toList();

        return doctors;
    }
}
