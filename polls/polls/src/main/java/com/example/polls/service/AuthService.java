package com.example.polls.service;

import com.example.polls.exception.PasswordResetLinkException;
import com.example.polls.exception.ResourceAlreadyInUseException;
import com.example.polls.exception.ResourceNotFoundException;
import com.example.polls.model.User;
import com.example.polls.model.token.ConfirmationToken;
import com.example.polls.model.token.TokenStatus;
import com.example.polls.model.token.TokenType;
import com.example.polls.payload.PasswordResetLinkRequest;
import com.example.polls.payload.SignUpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;
import java.util.Optional;

@Service
public class AuthService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ConfirmationTokenService confirmationTokenService;


    public Optional<User> registerUser(SignUpRequest signUpRequest){
        if(usernameAlreadyExists(signUpRequest.getUsername())){
            logger.error("Email already exists: " + signUpRequest);
            throw new ResourceAlreadyInUseException("Username", "Address", signUpRequest);
        }
        if(emailAlreadyExists(signUpRequest.getEmail())){
            logger.error("Email already exists: " + signUpRequest);
            throw new ResourceAlreadyInUseException("Email", "Address", signUpRequest);
        }
        User newUser = userService.createUser(signUpRequest);
        User registeredNewUser = userService.save(newUser);
        return Optional.ofNullable(registeredNewUser);
    }

    public Optional<User> confirmEmailRegistration(String emailToken) {
        ConfirmationToken emailVerificationToken = confirmationTokenService.findByToken(emailToken)
                .orElseThrow(() -> new ResourceNotFoundException("Token", "Email verification", emailToken));

        User registeredUser = emailVerificationToken.getUser();
        if (registeredUser.getEmailVerified()) {
            logger.info("User [" + emailToken + "] already registered.");
            return Optional.of(registeredUser);
        }

        confirmationTokenService.verifyExpiration(emailVerificationToken);
        emailVerificationToken.setConfirmedStatus();
        confirmationTokenService.save(emailVerificationToken);

        registeredUser.markVerificationConfirmed();
        userService.save(registeredUser);
        return Optional.of(registeredUser);
    }

    private Boolean usernameAlreadyExists(String username){
        return userService.existsByUsername(username);
    }

    private Boolean emailAlreadyExists(String email) {
        return userService.existsByEmail(email);
    }


    public Optional<ConfirmationToken> generatePasswordResetToken(PasswordResetLinkRequest passwordResetLinkRequest) {
        String email = passwordResetLinkRequest.getEmail();

        return userService.findByEmail(email)
                .map(user -> {
                    ConfirmationToken passwordResetToken = confirmationTokenService.createNewConfirmationToken(user, TokenType.TYPE_CONFIRM_PASSWORD);
                    confirmationTokenService.save(passwordResetToken);
                    return Optional.of(passwordResetToken);
                })
                .orElseThrow( () -> new PasswordResetLinkException(email, "No matching user found for the given request"));
    }
}
