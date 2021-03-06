package com.example.polls.controller;

import com.example.polls.event.OnGenerateResetLinkEvent;
import com.example.polls.event.OnUserRegistrationCompleteEvent;
import com.example.polls.exception.InvalidTokenRequestException;
import com.example.polls.exception.PasswordResetLinkException;
import com.example.polls.exception.UserRegistrationException;
import com.example.polls.payload.*;
import com.example.polls.security.JwtTokenProvider;
import com.example.polls.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

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
    private ApplicationEventPublisher applicationEventPublisher;


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

                    UriComponentsBuilder urlBuilder = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/auth/confirm-account");
                    OnUserRegistrationCompleteEvent onUserRegistrationCompleteEvent = new OnUserRegistrationCompleteEvent(user, urlBuilder);
                    applicationEventPublisher.publishEvent(onUserRegistrationCompleteEvent);

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

    @PostMapping("/password/resetlink")
    public ResponseEntity resetLink(@Valid @RequestBody PasswordResetLinkRequest passwordResetLinkRequest) {

        return authService.generatePasswordResetToken(passwordResetLinkRequest)
                .map(passwordResetToken -> {
                    UriComponentsBuilder urlBuilder = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/auth/password/reset");
                    OnGenerateResetLinkEvent generateResetLinkMailEvent = new OnGenerateResetLinkEvent(passwordResetToken, urlBuilder);
                    applicationEventPublisher.publishEvent(generateResetLinkMailEvent);
                    return ResponseEntity.ok(new ApiResponse(true, "Password reset link sent successfully"));
                })
                .orElseThrow(() -> new PasswordResetLinkException(passwordResetLinkRequest.getEmail(), "Couldn't create a valid token"));
    }

    /**
     * Receives a new passwordResetRequest and sends the acknowledgement after
     * changing the password to the user's mail through the event.
     */

//    @PostMapping("/password/reset")
//    @ApiOperation(value = "Reset the password after verification and publish an event to send the acknowledgement " +
//            "email")
//    public ResponseEntity resetPassword(@ApiParam(value = "The PasswordResetRequest payload") @Valid @RequestBody PasswordResetRequest passwordResetRequest) {
//
//        return authService.resetPassword(passwordResetRequest)
//                .map(changedUser -> {
//                    OnUserAccountChangeEvent onPasswordChangeEvent = new OnUserAccountChangeEvent(changedUser, "Reset Password",
//                            "Changed Successfully");
//                    applicationEventPublisher.publishEvent(onPasswordChangeEvent);
//                    return ResponseEntity.ok(new ApiResponse(true, "Password changed successfully"));
//                })
//                .orElseThrow(() -> new PasswordResetException(passwordResetRequest.getToken(), "Error in resetting password"));
//    }


}
