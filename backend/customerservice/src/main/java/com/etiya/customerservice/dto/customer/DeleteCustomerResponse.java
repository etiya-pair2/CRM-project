package com.etiya.customerservice.dto.customer;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeleteCustomerResponse {
    private UUID id;
    private boolean status;

}
