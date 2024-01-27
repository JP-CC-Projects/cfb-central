package com.jpcc.CFBProject.security.securitycontroller;

import com.jpcc.CFBProject.request.RefreshTokenRequest;
import com.jpcc.CFBProject.request.SignInRequest;
import com.jpcc.CFBProject.response.AccessTokenResponse;
import com.jpcc.CFBProject.response.JwtAuthenticationResponse;
import com.jpcc.CFBProject.response.TokenRefreshResponse;
import com.jpcc.CFBProject.security.securitydomain.RefreshToken;
import com.jpcc.CFBProject.security.securitydomain.User;
import com.jpcc.CFBProject.security.securityservices.JwtService;
import com.jpcc.CFBProject.security.securityservices.RefreshTokenService;
import com.jpcc.CFBProject.security.securityservices.UserServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.jpcc.CFBProject.security.securityservices.AuthenticationServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class AuthenticationController {
    private final AuthenticationServiceImpl authenticationService;
    private final RefreshTokenService refreshTokenService;
    private final JwtService jwtService;
    private final UserServiceImpl userService;

    public AuthenticationController(AuthenticationServiceImpl authenticationService,
                                    RefreshTokenService refreshTokenService,
                                    JwtService jwtService,
                                    UserServiceImpl userService) {
        super();
        this.authenticationService = authenticationService;
        this.refreshTokenService = refreshTokenService;
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @PostMapping("/refreshtoken")
    public ResponseEntity<?> refreshtoken(@RequestBody RefreshTokenRequest request, HttpServletResponse response) {
        String requestRefreshToken = request.refreshToken();
        return refreshTokenService.findByToken(requestRefreshToken)
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String token = jwtService.generateToken(user);
                    ResponseCookie refreshCookie = ResponseCookie.from("refreshToken", requestRefreshToken)
                            .httpOnly(true)
                            .secure(true)
                            .path("/") //Allows refresh token to be valid across whole site
                            .sameSite("Lax")
                            .build();
                    response.addHeader("Set-Cookie", refreshCookie.toString());
                    return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
                })
                .orElseThrow(() -> new IllegalStateException(
                        "Refresh token " + requestRefreshToken + " is not in database!"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateLogin(@RequestBody SignInRequest request, HttpServletResponse response) {
        Optional<User> existingUser = userService.findUserByEmail(request.email());
        if (existingUser.isPresent()) {
            JwtAuthenticationResponse jwtAuthResponse = authenticationService.signin(request);
            String accessToken = jwtAuthResponse.token();
            String refreshToken = jwtAuthResponse.refreshToken();

            // Send refresh token as HTTP-only cookie
            ResponseCookie refreshCookie = ResponseCookie.from("refreshToken", refreshToken)
                    .httpOnly(true)
                    .secure(true) // Use with HTTPS in production
                    .path("/")
                    .sameSite("Lax") // CSRF protection
                    .build();
            response.addHeader("Set-Cookie", refreshCookie.toString());

            // Send access token in the response body
            return ResponseEntity.ok(new AccessTokenResponse(accessToken));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
        }
    }

}

