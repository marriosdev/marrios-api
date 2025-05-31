package com.marrios.api.exception.handler;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse implements Serializable{
    private static final long serialVersionUID = 1L;

    private @Getter @Setter LocalDateTime timestamp;

    private @Getter @Setter String error;

    private @Getter @Setter Integer status;

    private @Getter @Setter String message;
}