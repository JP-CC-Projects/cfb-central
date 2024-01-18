package com.jpcc.CFBProject.security.securitycontroller;

import com.jpcc.CFBProject.request.RefreshTokenRequest;
import com.jpcc.CFBProject.request.SignInRequest;
import com.jpcc.CFBProject.response.JwtAuthenticationResponse;
import com.jpcc.CFBProject.response.TokenRefreshResponse;
import com.jpcc.CFBProject.security.securitydomain.RefreshToken;
import com.jpcc.CFBProject.security.securitydomain.User;
import com.jpcc.CFBProject.security.securityservices.JwtService;
import com.jpcc.CFBProject.security.securityservices.RefreshTokenService;
import com.jpcc.CFBProject.security.securityservices.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.jpcc.CFBProject.security.securityservices.AuthenticationServiceImpl;
import java.util.Optional;

//@RestController
//@RequestMapping("/api/v1/auth")
@Controller
public class AuthenticationController {
    private final AuthenticationServiceImpl authenticationService;
    private final RefreshTokenService refreshTokenService;
    private final JwtService jwtService;
    private final UserServiceImpl userService;
    
    public AuthenticationController(AuthenticationServiceImpl authenticationService,
			RefreshTokenService refreshTokenService, JwtService jwtService, UserServiceImpl userService) {
		super();
		this.authenticationService = authenticationService;
		this.refreshTokenService = refreshTokenService;
		this.jwtService = jwtService;
		this.userService = userService;
	}
    

    @GetMapping("/login")
	public String getLogin (@ModelAttribute("user") User user) {
		return "login";
	}
    
    @GetMapping("/login-error")
    public String loginError (Model model) {
    	model.addAttribute("loginError", true);
    	return "login";
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest request, @RequestBody User user) {
    	Optional<User> existingUser = userService.findUserByEmail(user.getEmail());
    	String accessToken = jwtService.generateToken(user);
        return ResponseEntity.ok(authenticationService.signin(request));
    }


//	 This code is from Trevor's original implementation which might be helpful for those who are not using server rendering templates

//	 @PostMapping("/signin") public String authenticateLogin
//	 (@ModelAttribute("user") User user, SignInRequest request) {
//	 Optional<User> existingUser = userService.findUserByEmail(user.getEmail());
//	 User loggedUser = ((User) userService).loadUserByUsername(user.getUsername());
//	 String accessToken = jwtService.generateToken(user);
//	 return ResponseEntity.ok(authenticationService.signin(request));
//	}
    
    @PostMapping("/refreshtoken")
    public ResponseEntity<?> refreshtoken(@RequestBody RefreshTokenRequest request) {
      String requestRefreshToken = request.refreshToken();
      return refreshTokenService.findByToken(requestRefreshToken)
          .map(refreshTokenService::verifyExpiration)
          .map(RefreshToken::getUser)
          .map(user -> {
            String token = jwtService.generateToken(user);
            return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
          })
          .orElseThrow(() -> new IllegalStateException(
              "Refresh token " + requestRefreshToken + " is not in database!"));
    }
}