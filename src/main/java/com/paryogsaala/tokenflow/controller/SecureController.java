package com.paryogsaala.tokenflow.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {
    @GetMapping("/api/secure/profile")
    public String getProfile(Authentication authentication) {
        return "Welcome, " + authentication.getName();
    }

    @GetMapping("/api/user/dashboard")
    @PreAuthorize("hasRole('USER')")
    public String getUserDashboard() {
        return "Welcome to the USER Dashboard!";
    }
    @GetMapping("/api/admin/dashboard")
    @PreAuthorize("hasRole('ADMIN')")
    public String getAdminDashboard() {
        return "Admin Dashboard";
    }
}
