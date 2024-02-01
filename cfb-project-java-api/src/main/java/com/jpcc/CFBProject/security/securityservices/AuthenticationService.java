package com.jpcc.CFBProject.security.securityservices;

import com.jpcc.CFBProject.request.SignInRequest;
import com.jpcc.CFBProject.request.SignUpRequest;
import com.jpcc.CFBProject.request.UpdateProfileRequest;
import com.jpcc.CFBProject.response.JwtAuthenticationResponse;
import com.jpcc.CFBProject.response.JwtUserUpdateResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);
    JwtAuthenticationResponse signin(SignInRequest request);
    void verifyUserBeforeUpdate(UpdateProfileRequest request);
    JwtUserUpdateResponse issueNewTokens(String userEmail);
}