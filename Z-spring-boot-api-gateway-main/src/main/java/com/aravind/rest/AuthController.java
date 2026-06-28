package com.aravind.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.aravind.entity.Users;
import com.aravind.service.JWTService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JWTService jwt;

    @PostMapping("/login")
    public ResponseEntity<String> loginCheck(@RequestBody Users c) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(c.getUserName(), c.getPassword());

        try {
            Authentication authenticate = authManager.authenticate(token);

            if (authenticate.isAuthenticated()) {
                String jwtToken = jwt.generateToken(c.getUserName());
                return new ResponseEntity<>(jwtToken, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Credentials are not correct", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Invalid Credentials", HttpStatus.BAD_REQUEST);
    }
}
