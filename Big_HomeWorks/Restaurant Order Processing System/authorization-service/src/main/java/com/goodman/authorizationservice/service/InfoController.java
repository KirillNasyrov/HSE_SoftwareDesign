package com.goodman.authorizationservice.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/info")
public class InfoController {
    @Autowired
    private InfoService infoService;
    @GetMapping()
    public ResponseEntity<?> getInfo(@NonNull HttpServletRequest request) {
        try {
            return ResponseEntity.ok(infoService.getInfo(request));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Unknown mistake");
        }

    }
}
