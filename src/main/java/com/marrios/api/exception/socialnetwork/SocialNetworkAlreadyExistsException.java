package com.marrios.api.exception.socialnetwork;

import org.springframework.http.HttpStatus;

public class SocialNetworkAlreadyExistsException extends RuntimeException {
    private final HttpStatus status;
    private final String errorCode;

    public SocialNetworkAlreadyExistsException(String name) {
        super(String.format("Rede social '%s' já existe", name));
        this.status = HttpStatus.BAD_REQUEST;
        this.errorCode = "SOCIAL_NETWORK_ALREADY_EXISTS";
    }

    // Getters
    public HttpStatus getStatus() {
        return status;
    }

    public String getErrorCode() {
        return errorCode;
    }
}