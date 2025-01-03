package com.umrahoperations.UmrahOperations.security;// SecurityConfig.java
// SecurityConfig.java
import com.umrahoperations.UmrahOperations.utils.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthenticationFilter jwtAuthenticationFilter) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF for stateless APIs
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS)) // Stateless session
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/api",
                                "/api/auth/login",
                                "/api/auth/verify",
                                "/api/currency",
                                "/api/extravisaprice",
                                "/api/visa-requests",
                                "/api/visa-followups/{eacode}",
                                "/api/visa-followups/with-agent/{eacode}",
                                "/api/visa-requests/delete/{vrId}",
                                "/api/visa-requests/updateStatus",
                                "/api/wallet/{entityId}",
                                "/api/paymentmode",
                                "/api/countries",
                                "/api/accounts/list/{eaCode}",
                                "/api/lookups/bankAccounts/{entityId}",
                                "/api/wallets",
                                    "/api/book-hotel-data/**","/api/hotel-followup/**","/api/flight/**","/api/flight-booking").permitAll() // Allow login without authentication
                        .anyRequest().authenticated() // Require authentication for other requests
                );

        // Add JWT filter before UsernamePasswordAuthenticationFilter
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
