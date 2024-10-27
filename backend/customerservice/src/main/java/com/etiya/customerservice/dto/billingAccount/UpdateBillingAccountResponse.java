package com.etiya.customerservice.dto.billingAccount;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateBillingAccountResponse {
    private UUID id;
    private UUID customerId;
    private UUID addressId;
    private String description;
    private String accountName;
    private String accountNumber;
    private Boolean accountStatus;
    private String accountType;
    private String action;
}
