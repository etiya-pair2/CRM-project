package com.etiya.productservice.core.configuration.exceptions.type;


public class BusinessException extends RuntimeException
{
    public BusinessException(String message) {
        super(message);
    }
}