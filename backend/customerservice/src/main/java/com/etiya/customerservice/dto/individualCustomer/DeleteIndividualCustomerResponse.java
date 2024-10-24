package com.etiya.customerservice.dto.individualCustomer;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeleteIndividualCustomerResponse {
    private UUID customerId;
    private boolean status;

}
