package com.etiya.customerservice.dto.contactMedium;

import com.etiya.customerservice.entity.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateContactMediumResponse {
    private UUID id;
    private UUID customerId;
    private String email;
    private Long homePhone;
    private Long mobilePhone;
    private String fax;
}
