package com.appointment.docter_service.Controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/open")
public class OpenController {

    private final OpenService openService;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody @Valid LoginDto userDto,
                                       HttpServletResponse response) {
        try {
            String jwtToken = openService.login(userDto);

            // Set token in HTTP-only cookie
            ResponseCookie cookie = ResponseCookie.from("doctor-token", jwtToken)
                    .httpOnly(true)
                    .secure(true) // Set to true in production with HTTPS
                    .path("/")
                    .maxAge(3600 * 24 * 30)
                    .build();

            response.addHeader("Set-Cookie", cookie.toString());

            return ResponseEntity.ok("Login successful");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("error"+e.getMessage());
        }
    }
}
