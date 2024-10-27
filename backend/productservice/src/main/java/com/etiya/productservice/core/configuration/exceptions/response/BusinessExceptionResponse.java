package com.etiya.productservice.core.configuration.exceptions.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class BusinessExceptionResponse {

    private String message;

    public BusinessExceptionResponse(String message) {
        this.message = message;
    }


}
