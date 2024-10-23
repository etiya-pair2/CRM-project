package com.etiya.customerservice.dto.billingAccount;

import com.etiya.customerservice.entity.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetAllBillingAccountResponse {
    private UUID id;
    private UUID customerId;
    private String accountNumber;
    private Boolean accountStatus;
    private String action;
}
