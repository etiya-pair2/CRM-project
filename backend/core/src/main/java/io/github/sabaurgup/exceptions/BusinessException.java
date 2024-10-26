package io.github.sabaurgup.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String message;

    public BusinessException(String message) {
        super(message);
    }

}