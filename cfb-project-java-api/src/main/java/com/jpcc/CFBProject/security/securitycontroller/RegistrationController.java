package com.jpcc.CFBProject.security.securitycontroller;

import com.jpcc.CFBProject.request.SignUpRequest;
import com.jpcc.CFBProject.response.JwtAuthenticationResponse;
import com.jpcc.CFBProject.security.securityservices.JwtServiceImpl;
import com.jpcc.CFBProject.security.securityservices.RefreshTokenService;
import com.jpcc.CFBProject.security.securityservices.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import com.jpcc.CFBProject.security.securityservices.AuthenticationServiceImpl;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RegistrationController {

    private UserServiceImpl userService;
    private AuthenticationServiceImpl authenticationService;
    private JwtServiceImpl jwtService;
    private RefreshTokenService refreshTokenService;
    private PasswordEncoder passwordEncoder;
    private Logger logger = LoggerFactory.getLogger(RegistrationController.class);


    public RegistrationController(UserServiceImpl userService, AuthenticationServiceImpl authenticationService,
                                  JwtServiceImpl jwtService, RefreshTokenService refreshTokenService, PasswordEncoder passwordEncoder) {
        super();
        this.userService = userService;
        this.authenticationService = authenticationService;
        this.jwtService = jwtService;
        this.refreshTokenService = refreshTokenService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }
}

