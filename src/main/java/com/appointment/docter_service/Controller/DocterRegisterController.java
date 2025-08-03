package com.appointment.docter_service.Controller;

import com.appointment.docter_service.Dtos.DocterRegisterDto;
import com.appointment.docter_service.Service.DocterRegisterService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
@AllArgsConstructor
public class DocterRegisterController {

    private final DocterRegisterService docterRegisterService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody @Valid DocterRegisterDto docterDto) {
        System.out.println("Received registration request: " + docterDto.toString());
        try {
            docterRegisterService.register(docterDto); // Service does logic, throws error if needed
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
            boolean exists = docterRegisterService.isDocterExists(docterId);
            return ResponseEntity.ok(exists);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Something went wrong: " + e.getMessage());
        }
    }
}
