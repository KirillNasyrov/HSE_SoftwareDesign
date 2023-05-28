package com.goodman.authorizationservice.gettingrole;

import com.goodman.authorizationservice.user.Role;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/role")
@RequiredArgsConstructor
public class RoleController {
    @Autowired
    RoleService roleService;
    @PostMapping("/set")
    public ResponseEntity<String> register (@NonNull HttpServletRequest request, @RequestBody Role role) {
        roleService.setNewRole(request, role);
        return ResponseEntity.ok("role changed");
    }
}
