package com.etiya.customerservice.dto.customer;

import jakarta.persistence.Column;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetAllCustomerResponse {
    private UUID id;
    private Date createdDate;
    private Date updatedDate;
    private boolean status;
}
