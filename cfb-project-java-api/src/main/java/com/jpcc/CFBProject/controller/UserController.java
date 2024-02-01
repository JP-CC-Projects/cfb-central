package com.jpcc.CFBProject.controller;

import com.jpcc.CFBProject.request.UpdateProfileRequest;
import com.jpcc.CFBProject.response.JwtUserUpdateResponse;
import com.jpcc.CFBProject.security.securitydomain.User;
import com.jpcc.CFBProject.security.securityservices.AuthenticationServiceImpl;
import com.jpcc.CFBProject.security.securityservices.JwtServiceImpl;
import com.jpcc.CFBProject.security.securityservices.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserServiceImpl userService;
    private AuthenticationServiceImpl authenticationService;
    private JwtServiceImpl jwtService;

    public UserController(UserServiceImpl userService, AuthenticationServiceImpl authenticationService, JwtServiceImpl jwtService) {
        this.userService = userService;
        this.authenticationService = authenticationService;
        this.jwtService = jwtService;
    }

    @GetMapping("/get-user-details")
    public ResponseEntity<?> getUserDetails(@RequestHeader("Authorization") String token) {
        String userEmail = jwtService.extractUserName(token);
        User currentUser = userService.findUserByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User Email not found!"));
        return ResponseEntity.ok(userService.mapUserToDTO(currentUser));
    }

    @PutMapping("/update-profile")
    public ResponseEntity<?> updateUserProfile(@RequestBody User requestedUserUpdate) {
        try {
            authenticationService.verifyUserBeforeUpdate(requestedUserUpdate);
            JwtUserUpdateResponse jwtResponse = authenticationService.issueNewTokens(requestedUserUpdate.email());
            return ResponseEntity.ok(jwtResponse);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating user profile");
        }
    }
}
