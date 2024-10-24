package com.etiya.customerservice.dto.corporateCustomer;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateCorporateCustomerResponse {
    private UUID customerId;
    private String companyName;
    private String taxNo;
    private boolean status;
    private Date createdDate;
    private Date updatedDate;
}
