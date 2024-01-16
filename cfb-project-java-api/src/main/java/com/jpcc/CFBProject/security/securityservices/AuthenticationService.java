package com.jpcc.CFBProject.security.securityservices;

import com.jpcc.CFBProject.request.SignInRequest;
import com.jpcc.CFBProject.request.SignUpRequest;
import com.jpcc.CFBProject.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);
    JwtAuthenticationResponse signin(SignInRequest request);
}