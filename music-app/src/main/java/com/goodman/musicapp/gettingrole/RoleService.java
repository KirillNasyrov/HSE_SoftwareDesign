package com.goodman.authorizationservice.gettingrole;

import com.goodman.authorizationservice.config.JwtService;
import com.goodman.authorizationservice.user.Role;
import com.goodman.authorizationservice.user.User;
import com.goodman.authorizationservice.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final JwtService jwtService;
    @Autowired
    UserRepository userRepository;

    public void setNewRole(HttpServletRequest request, Role role) {
        final String authHeader = request.getHeader("Authorization");
        String jwt = authHeader.substring(7);
        String userEmail = jwtService.extractEmail(jwt);
        Optional<User> user = userRepository.findByEmail(userEmail);
        user.get().setRole(role);
        userRepository.save(user.get());
    }
}
