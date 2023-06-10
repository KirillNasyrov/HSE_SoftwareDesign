package com.goodman.musicapp.service;

import com.goodman.musicapp.config.JwtService;
import com.goodman.musicapp.user.User;
import com.goodman.musicapp.user.UserRepository;
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
                .name(user.getUsername())
                .email(userEmail)
                .build();
    }
}
