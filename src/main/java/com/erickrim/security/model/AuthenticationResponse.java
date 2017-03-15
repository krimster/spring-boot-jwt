package com.erickrim.security.model;

/**
 * AuthenticationResponse
 * Created by krime on 3/15/17.
 */
public class AuthenticationResponse {
    private String token;

    public AuthenticationResponse() {
        super();
    }

    public AuthenticationResponse(String token) {
        this.setToken(token);
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
