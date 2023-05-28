package com.goodman.authorizationservice.service;

import com.goodman.authorizationservice.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InfoResponse {
    Role role;
    String name;
    String email;
}
