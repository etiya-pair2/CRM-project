package com.etiya.customerservice.dto.billingAccount;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeleteBillingAccountResponse {
    private UUID id;
    private UUID customerId;
}
