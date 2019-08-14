package com.example.social_login.controller;

import com.example.social_login.exception.ResourceNotFoundException;
import com.example.social_login.model.User;
import com.example.social_login.repository.UserRepository;
import com.example.social_login.security.oauth2.UserPrincipal;
import com.example.social_login.security.oauth2.annotations.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
