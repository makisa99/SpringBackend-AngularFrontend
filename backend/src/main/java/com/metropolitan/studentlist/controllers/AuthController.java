package com.metropolitan.studentlist.controllers;

import com.metropolitan.studentlist.payload.request.LoginDto;
import com.metropolitan.studentlist.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        if (authService.login(loginDto)) {
            return new ResponseEntity<>("Prijava uspešna!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Prijava nije uspešna!", HttpStatus.NOT_FOUND);
    }

}