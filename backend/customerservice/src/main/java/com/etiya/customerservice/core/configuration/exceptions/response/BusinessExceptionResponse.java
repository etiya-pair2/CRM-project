package com.etiya.customerservice.core.configuration.exceptions.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessExceptionResponse {

    private String message;

    public BusinessExceptionResponse(String message) {
        this.message = message;
    }


}
