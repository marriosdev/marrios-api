package com.marrios.api.exception.handler.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ValidateMessageErrorDto {
    private String field;
    private String message;
}
