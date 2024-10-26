package com.etiya.customerservice.dto.individualCustomer;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SearchIndCustomerRequest {
    private String natId;
    private UUID customerId;
    private String accNumber;
    private String mobilePhone;
    private String firstName;
    private String lastName ;
    private UUID orderId;
}
