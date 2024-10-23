package com.etiya.customerservice.dto.customer;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateCustomerRequest {
    private UUID id;
    private Date updatedDate;
    private boolean status;
}
