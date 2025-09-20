package com.appointment.docter_service.Controller;

import com.appointment.docter_service.Dtos.AppointmentDoctorDto;
import com.appointment.docter_service.Dtos.DoctorAvailabilityDto;
import com.appointment.docter_service.Dtos.DoctorRegisterDto;
import com.appointment.docter_service.Dtos.DoctorUpdateDto;
import com.appointment.docter_service.Dtos.DoctorByUsernameDto;
import com.appointment.docter_service.Entities.DoctorRegisterEntity;
import com.appointment.docter_service.Service.DoctorRegisterService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
@AllArgsConstructor
public class DoctorRegisterController {

    private final DoctorRegisterService doctorRegisterService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody @Valid DoctorRegisterDto docterDto) {
        System.out.println("Received registration request: " + docterDto.toString());
        try {
            doctorRegisterService.register(docterDto); // Service does logic, throws error if needed
            return ResponseEntity.ok("Docter registered successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace(); // 🔍 Print full error
            return ResponseEntity.internalServerError().body("Something went wrong: " + e.getMessage());
//            return ResponseEntity.internalServerError().body("Something went wrong.");
        }
    }

    @GetMapping("/exists/{docterId}")
    public ResponseEntity<?> isDocterExist(@PathVariable String docterId) {
        try {
            AppointmentDoctorDto exists = doctorRegisterService.getDoctorName(docterId);
            return ResponseEntity.ok(exists);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Something went wrong: " + e.getMessage());
        }
    }

    @GetMapping("/getAllDoctors")
    public ResponseEntity<?> getAllDoctors() {
        try{
            List<DoctorRegisterEntity> doctors = doctorRegisterService.getAllDoctors();
            return ResponseEntity.ok(doctors);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/delete/{docterId}")
    public ResponseEntity<?> deleteDoctor(@PathVariable String docterId) {
        try {
            doctorRegisterService.deleteDoctor(docterId);
            return ResponseEntity.ok("Doctor deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Something went wrong: " + e.getMessage());
        }
    }

    @PutMapping("/update/{doctorId}")
    public ResponseEntity<?> updateDoctor(@PathVariable String doctorId, @RequestBody @Valid DoctorUpdateDto updateDto) {
        try {
            doctorRegisterService.updateDoctorContactInfo(doctorId, updateDto);
            return ResponseEntity.ok("Doctor info updated successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Something went wrong: " + e.getMessage());
        }
    }

    @PutMapping("/updateDoctorAvailability")
    public ResponseEntity<?> updateDoctorAvailability(@RequestBody @Valid DoctorAvailabilityDto updateDto) {
        try {
            doctorRegisterService.updateDoctorAvailability(updateDto);
            return ResponseEntity.ok("Doctor availability updated successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Something went wrong: " + e.getMessage());
        }
    }

    // New endpoint: get doctor by username
    @GetMapping("/getDoctorByUsername/{username}")
    public ResponseEntity<?> getDoctorByUsername(@PathVariable String username) {
        try {
            DoctorByUsernameDto dto = doctorRegisterService.getDoctorByUsername(username);
            return ResponseEntity.ok(dto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Something went wrong: " + e.getMessage());
        }
    }

    @PatchMapping("/updateDoctorPresentyStatus/{username}")
    public ResponseEntity<?> updateDoctorPresentyStatus(@PathVariable String username) {
        try {
            doctorRegisterService.updateDoctorPresentyStatus(username);
            return ResponseEntity.ok("Doctor presenty status updated successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Something went wrong: " + e.getMessage());
        }
    }
}
