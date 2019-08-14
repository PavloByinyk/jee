package com.example.polls.event;

import com.example.polls.model.token.ConfirmationToken;
import org.springframework.context.ApplicationEvent;
import org.springframework.web.util.UriComponentsBuilder;

public class OnGenerateResetLinkEvent extends ApplicationEvent {

    private transient UriComponentsBuilder redirectUrl;

    private transient ConfirmationToken confirmationToken;

    public OnGenerateResetLinkEvent(ConfirmationToken passwordResetToken, UriComponentsBuilder redirectUrl) {
        super(passwordResetToken);
        this.confirmationToken = passwordResetToken;
        this.redirectUrl = redirectUrl;
    }

    public ConfirmationToken getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(ConfirmationToken confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public UriComponentsBuilder getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(UriComponentsBuilder redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

}