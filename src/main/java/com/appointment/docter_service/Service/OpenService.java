//package com.appointment.docter_service.Service;
//
//import com.appointment.docter_service.Repository.DoctorRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class OpenService {
//
//    private final DoctorRepository doctorRepository;
//
//
//    public String login(LoginDto userDto) {
//        Optional<UserRegistrationEntity> optionalUser = Optional.ofNullable(userRepository.findByUsername(userDto.username()));
//
//        if (optionalUser.isEmpty()) {
//            throw new IllegalArgumentException("Invalid username or password");
//        }
//
//        UserRegistrationEntity user = optionalUser.get();
//
//        if (!passwordEncoder.matches(userDto.password(), user.getPassword())) {
//            throw new IllegalArgumentException("Invalid username or password");
//        }
//
//        // Create and return JWT
//        return jwtUtil.generateToken(
//                user.getUsername(),
//                user.getId().toString(),
//                user.getEmail(),
//                "USER" // Replace with actual role if available
//        );
//    }
//
//}
