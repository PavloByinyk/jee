package com.example.polls.event.listener;


import com.example.polls.event.OnGenerateResetLinkEvent;
import com.example.polls.model.User;
import com.example.polls.model.token.ConfirmationToken;
import com.example.polls.service.EmailSenderService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.MailSendException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;

@Component
public class OnGenerateResetLinkEventListener implements ApplicationListener<OnGenerateResetLinkEvent> {

//    private static final Logger logger = Logger.getLogger(OnGenerateResetLinkEventListener.class);

    @Autowired
    private EmailSenderService mailService;

    @Autowired
    public OnGenerateResetLinkEventListener() {}

    /**
     * As soon as a forgot password link is clicked and a valid email id is entered,
     * Reset password link will be sent to respective mail via this event
     */
    @Override
    @Async
    public void onApplicationEvent(OnGenerateResetLinkEvent onGenerateResetLinkMailEvent) {
        sendResetLink(onGenerateResetLinkMailEvent);
    }

    /**
     * Sends Reset Link to the mail address with a password reset link token
     */
    private void sendResetLink(OnGenerateResetLinkEvent event) {
        ConfirmationToken passwordResetToken = event.getConfirmationToken();
        User user = passwordResetToken.getUser();
        String recipientAddress = user.getEmail();
        String emailConfirmationUrl = event.getRedirectUrl().queryParam("token", passwordResetToken.getConfirmationToken()).toUriString();
        mailService.sendResetLink(emailConfirmationUrl, recipientAddress);
    }

}
