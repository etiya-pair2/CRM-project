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
}
