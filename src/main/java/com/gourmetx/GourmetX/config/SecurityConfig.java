package com.gourmetx.GourmetX.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF for simplicity; adapt based on your security requirements
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/api/auth/**").permitAll()  // Allows authentication without login
                        .requestMatchers("/api/tables/**").permitAll()  // Allows access to /api/tables
                        .anyRequest().authenticated())  // Other requests require authentication
                .cors(cors -> cors  // Enables CORS
                        .configurationSource(corsConfigurationSource()));  // Configures specific CORS settings

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));  // Allows only localhost:4200 as origin
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));  // Allows these HTTP methods
        configuration.setAllowedHeaders(Arrays.asList("*"));  // Allows all headers
        configuration.setAllowCredentials(true);  // Allows sending cookies and credentials

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);  // Applies the CORS configuration to all routes
        return source;
    }
}
