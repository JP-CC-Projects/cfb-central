package com.jpcc.CFBProject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class NoOpSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource())) // Enable CORS and use the defined CORS configuration
                .authorizeHttpRequests(authz -> authz
                        .anyRequest().permitAll() // Permit all requests
                )
                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF protection
                .httpBasic(AbstractHttpConfigurer::disable) // Disable HTTP Basic Authentication
                .formLogin(AbstractHttpConfigurer::disable); // Disable form login

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // Allowing both localhost and the network IP
        List<String> allowedOrigins = Arrays.asList(
                "http://localhost:5173", // Frontend running on localhost
                "http://192.168.12.112:5173" // Frontend running on network IP
        );
        configuration.setAllowedOrigins(allowedOrigins);

        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
