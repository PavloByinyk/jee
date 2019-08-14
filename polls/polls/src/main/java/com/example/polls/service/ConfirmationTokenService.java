package com.example.polls.service;

import com.example.polls.exception.InvalidTokenRequestException;
import com.example.polls.model.User;
import com.example.polls.model.token.ConfirmationToken;
import com.example.polls.model.token.TokenType;
import com.example.polls.repository.ConfirmationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class ConfirmationTokenService {

    @Value("${app.token.email.verification.duration}")
    private Long emailVerificationTokenExpiryDuration;


    @Autowired
    private ConfirmationTokenRepository tokenRepository;

    public Optional<ConfirmationToken> findByToken(String token){
        return tokenRepository.findByConfirmationToken(token);
    }

    public ConfirmationToken save(ConfirmationToken confirmationToken){
        return tokenRepository.save(confirmationToken);
    }


    public ConfirmationToken createNewConfirmationToken(User user, TokenType tokenType){
        return new ConfirmationToken(user, tokenType);
    }


    /**
     * Verify whether the token provided has expired or not on the basis of the current
     * server time and/or throw error otherwise
     */
    public void verifyExpiration(ConfirmationToken token) {
        if ((token.getCreatedDate().plusMillis(emailVerificationTokenExpiryDuration).compareTo(Instant.now())) < 0) {
            throw new InvalidTokenRequestException("Email Verification Token", token.getConfirmationToken(), "Expired token. Please issue a new request");
        }
    }

}
