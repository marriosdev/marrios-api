package com.marrios.api.exception.handler;

import com.marrios.api.exception.socialnetwork.SocialNetworkAlreadyExistsException;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;

@RestControllerAdvice
@NoArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SocialNetworkAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleSocialNetworkAlreadyExistsException(SocialNetworkAlreadyExistsException ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse();
        response.setStatus(ex.getStatus().value());
        response.setMessage(ex.getMessage());
        response.setError(ex.getErrorCode());
        response.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}