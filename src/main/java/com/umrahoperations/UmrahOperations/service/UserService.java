package com.umrahoperations.UmrahOperations.service;

import com.umrahoperations.UmrahOperations.dto.AuthResponseDTO;
import com.umrahoperations.UmrahOperations.dto.HeaderDTO;
import com.umrahoperations.UmrahOperations.dto.MenuDTO;
import com.umrahoperations.UmrahOperations.dto.UserDTO;
import com.umrahoperations.UmrahOperations.model.LoginPrev;
import com.umrahoperations.UmrahOperations.repository.UserRepository;
import com.umrahoperations.UmrahOperations.utils.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtil;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public AuthResponseDTO authenticate(String emailId, String password) throws Exception {
        logger.info("Attempting to authenticate user with email: {}", emailId);

        List<LoginPrev> loginPrevs = userRepository.findAllUsers();




        List<LoginPrev> filteredLoginPrevs = loginPrevs.stream()
                .filter(row -> row.getUserLogin().equals(emailId) && row.getUserPass().equals(password))
                .collect(Collectors.toList());

        if (filteredLoginPrevs.isEmpty()) {
            throw new Exception("Invalid credentials");
        }

        UserDTO userDTO = new UserDTO();
        Map<String, HeaderDTO> headerMap = new HashMap<>();

        for (LoginPrev lp : filteredLoginPrevs) {
            // Set user details only once
            if (userDTO.getId() == null) {
                userDTO.setId(lp.getUserId());
                userDTO.setUsername(lp.getUserName());
                userDTO.setEmail(lp.getUserLogin());
                userDTO.setCountryCode(lp.getCountryCode());
                userDTO.setStatus(String.valueOf(lp.getUserStatus()));
                userDTO.setAgentCode(lp.getEaCode());
                userDTO.setAgentCurrency(lp.getCountryCode());
                userDTO.setVrId(lp.getUserId());
            }


            // Process headers and menus
            String headerName = lp.getMhNameLa();
            String menuName = lp.getMnNameLa();

            HeaderDTO headerDTO = headerMap.computeIfAbsent(headerName, k -> new HeaderDTO(headerName, new ArrayList<>()));
            MenuDTO menuDTO = new MenuDTO(menuName, headerName);
            headerDTO.getMenus().add(menuDTO);
        }

        List<HeaderDTO> headers = new ArrayList<>(headerMap.values());

        // Generate token with email and country code
        String token = jwtUtil.generateToken(userDTO.getEmail(), userDTO.getCountryCode());

        logger.info("Authentication successful for user: {}", emailId);
        return new AuthResponseDTO(token, userDTO, headers);
    }
}