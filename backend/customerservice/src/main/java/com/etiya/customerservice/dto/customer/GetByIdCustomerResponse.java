package com.etiya.customerservice.dto.customer;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetByIdCustomerResponse {
    private UUID id;
    private Date createdDate;
    private Date updatedDate;
    private boolean status;
}
