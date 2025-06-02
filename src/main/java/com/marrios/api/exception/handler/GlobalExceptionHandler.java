package com.marrios.api.exception.handler;

import com.marrios.api.exception.handler.dto.ValidateMessageErrorDto;
import com.marrios.api.exception.socialnetwork.SocialNetworkAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.lang.reflect.GenericArrayType;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SocialNetworkAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleSocialNetworkAlreadyExistsException(SocialNetworkAlreadyExistsException ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse();
        response.setStatus(ex.getStatus().value());
        response.setMessage(ex.getMessage());
        response.setError(ex.getErrorCode());
        response.setTimestamp(LocalDateTime.now());
        response.setPath(request.getDescription(false).replace("uri=", ""));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setError("VALIDATION_ERROR");
        response.setMessage("Campos inválidos");
        response.setTimestamp(LocalDateTime.now());
        response.setPath(request.getDescription(false).replaceFirst("uri=", ""));

        List<ValidateMessageErrorDto> errorsList = new ArrayList<>();

        ex.getBindingResult().getFieldErrors().forEach(e -> {
            ValidateMessageErrorDto dto = new ValidateMessageErrorDto();
            dto.setField(e.getField());
            dto.setMessage(e.getDefaultMessage());
            errorsList.add(dto);
        });

        response.setErrors(errorsList);
        return ResponseEntity.badRequest().body(response);
    }
}
