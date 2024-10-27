package io.github.sabaurgup.exceptions.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


public class BusinessException extends RuntimeException
{
    public BusinessException(String message) {
        super(message);
    }
}