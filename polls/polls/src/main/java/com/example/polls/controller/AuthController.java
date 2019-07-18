package com.example.polls.controller;

import com.example.polls.exception.InvalidTokenRequestException;
import com.example.polls.exception.UserRegistrationException;
import com.example.polls.model.token.ConfirmationToken;
import com.example.polls.payload.ApiResponse;
import com.example.polls.payload.JwtAuthenticationResponse;
import com.example.polls.payload.LoginRequest;
import com.example.polls.payload.SignUpRequest;
import com.example.polls.repository.ConfirmationTokenRepository;
import com.example.polls.security.JwtTokenProvider;
import com.example.polls.service.AuthService;
import com.example.polls.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        JwtAuthenticationResponse jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(jwt);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        return authService.registerUser(signUpRequest)
                .map(user -> {


                    ConfirmationToken confirmationToken = new ConfirmationToken(user);
                    confirmationTokenRepository.save(confirmationToken);
                    SimpleMailMessage mailMessage = new SimpleMailMessage();
                    mailMessage.setTo(user.getEmail());
                    mailMessage.setSubject("Complete Registration!");
                    mailMessage.setFrom("chand312902@gmail.com");
                    mailMessage.setText("To confirm your account, please click here : "
                            + "http://localhost:5000/api/auth/confirm-account?token="+ confirmationToken.getConfirmationToken());
                    emailSenderService.sendEmail(mailMessage);



                    URI location = ServletUriComponentsBuilder
                            .fromCurrentContextPath().path("/api/users/{username}")
                            .buildAndExpand(user.getUsername()).toUri();
                    return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully. Check your email for verification"));
                })
                .orElseThrow(() -> new UserRegistrationException(signUpRequest.getEmail(), "Missing user object in database"));
    }


    @GetMapping("/confirm-account")
    public ResponseEntity confirmRegistration(@RequestParam("token") String token) {
        return authService.confirmEmailRegistration(token)
                .map(user -> ResponseEntity.ok(new ApiResponse(true, "User verified successfully")))
                .orElseThrow(() -> new InvalidTokenRequestException("Email Verification Token", token, "Failed to confirm. Please generate a new email verification request"));
    }
}
