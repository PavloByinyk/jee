package com.example.polls.payload;

public class JwtAuthenticationResponse {
    private String accessToken;
    private long expTime;
    private String tokenType = "Bearer";

    public JwtAuthenticationResponse(String accessToken, long expTime) {
        this.accessToken = accessToken;
        this.expTime = expTime;
    }

    public long getExpTime() {
        return expTime;
    }

    public void setExpTime(long expTime) {
        this.expTime = expTime;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
