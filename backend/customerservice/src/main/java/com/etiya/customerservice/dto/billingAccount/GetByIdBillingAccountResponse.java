package com.etiya.customerservice.dto.billingAccount;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetByIdBillingAccountResponse {
    private UUID id;
    private UUID customerId;
    private String accountNumber;
    private Boolean accountStatus;
    private String action;
    private String accountName;
}
