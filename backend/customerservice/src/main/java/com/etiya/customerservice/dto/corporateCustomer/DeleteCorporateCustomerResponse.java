package com.etiya.customerservice.dto.corporateCustomer;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeleteCorporateCustomerResponse {
    private UUID customerId;
    private boolean status;
}
