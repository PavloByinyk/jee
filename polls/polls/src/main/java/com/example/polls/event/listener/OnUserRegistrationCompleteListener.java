package com.example.polls.event.listener;

import com.example.polls.event.OnUserRegistrationCompleteEvent;
import com.example.polls.model.User;
import com.example.polls.model.token.ConfirmationToken;
import com.example.polls.model.token.TokenType;
import com.example.polls.service.ConfirmationTokenService;
import com.example.polls.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class OnUserRegistrationCompleteListener implements ApplicationListener<OnUserRegistrationCompleteEvent> {

//    private static final Logger logger = Logger.(OnUserRegistrationCompleteListener.class);
    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    public OnUserRegistrationCompleteListener() {}

    /**
     * As soon as a registration event is complete, invoke the email verification
     * asynchronously in an another thread pool
     */
    @Override
    @Async
    public void onApplicationEvent(OnUserRegistrationCompleteEvent onUserRegistrationCompleteEvent) {
        sendEmailVerification(onUserRegistrationCompleteEvent);
    }

    /**
     * Send email verification to the user and persist the token in the database.
     */
    private void sendEmailVerification(OnUserRegistrationCompleteEvent event){

        User user = event.getUser();
        ConfirmationToken confirmationToken = confirmationTokenService.createNewConfirmationToken(user, TokenType.TYPE_CONFIRM_EMAIL);
        confirmationTokenService.save(confirmationToken);

        String recipientAddress = user.getEmail();
        String emailConfirmationUrl = event.getRedirectUrl().queryParam("token", confirmationToken.getConfirmationToken()).toUriString();

        emailSenderService.sendEmailVerification(emailConfirmationUrl, recipientAddress);

    }
}