package com.jpcc.CFBProject.security.securitycontroller;

import com.jpcc.CFBProject.security.securitydomain.User;
import com.jpcc.CFBProject.security.securityrepository.UserRepository;
import com.jpcc.CFBProject.security.securityservices.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//@RestController
@Controller
@RequestMapping("/admin")
public class SecurityAdminController {
    private UserServiceImpl userService;
    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;
    private Logger logger = LoggerFactory.getLogger(SecurityAdminController.class);
    
    public SecurityAdminController(UserServiceImpl userService, UserRepository userRepo, PasswordEncoder passwordEncoder) {
		super();
		this.userService = userService;
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
	}

	List<User> allAdmins = new ArrayList<>();


    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers () {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }
    
    @GetMapping("/dashboard")
    public String getDashboard (ModelMap model) {
    	List<User> users = userService.findAll();
    	model.addAttribute("userList", users);
    	return "dashboard";
    }
    
    @PostMapping("/makeAdmin")
    public ResponseEntity<String> elevateToAdmin (@RequestParam Integer userId) {
    	Optional<User> findUser = userService.findUserById(userId);
    	    	
    	userService.elevateUserToAdmin(userId);
    	logger.info("Processing elevation for user: {}", findUser.get().getEmail());
    	logger.info("Role: {}", findUser.get().getAuthorities());
    	return ResponseEntity.ok("User elevated to admin");
    }
}
