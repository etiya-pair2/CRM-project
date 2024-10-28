package com.etiya.productservice.dto.attribute;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

@Data
public class UpdateAttributeRequest {

    private UUID id;

    @Size(min = 2, max = 30, message = "Attribute name must be between 2 and 30 characters")
    private String name;
}
