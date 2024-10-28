package com.etiya.productservice.dto.attribute;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateAttributeRequest {

    @Size(min = 2, max = 30, message = "Attribute name must be between 2 and 30 characters")
    private String name;
}
