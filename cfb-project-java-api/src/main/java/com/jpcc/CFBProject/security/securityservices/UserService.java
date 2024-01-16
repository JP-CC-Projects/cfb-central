package com.jpcc.CFBProject.security.securityservices;
import com.jpcc.CFBProject.security.securitydomain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    UserDetailsService userDetailsService();
    List<User> findAll();
}