package com.goodman.authorizationservice.service;

import com.goodman.authorizationservice.config.JwtService;
import com.goodman.authorizationservice.user.User;
import com.goodman.authorizationservice.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InfoService {
    private final JwtService jwtService;
    private final UserRepository userRepository;

    public InfoResponse getInfo(HttpServletRequest request) {
        final String authHeader = request.getHeader("Authorization");
        String jwt = authHeader.substring(7);
        String userEmail = jwtService.extractEmail(jwt);
        User user = userRepository.findByEmail(userEmail).get();

        return InfoResponse.builder()
                .role(user.getRole())
                .name(user.getUsername())
                .email(userEmail)
                .build();
    }
}
