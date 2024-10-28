package com.umrahoperations.UmrahOperations.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrentUserUtil {

    @Autowired
    private JwtUtils jwtUtils;

    public Integer getCurrentUserCountryCode(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            return jwtUtils.extractCountryCode(token);
        }
        return null;
    }
}