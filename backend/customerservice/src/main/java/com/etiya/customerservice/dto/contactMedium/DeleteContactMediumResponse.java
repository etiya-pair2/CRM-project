package com.etiya.customerservice.dto.contactMedium;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeleteContactMediumResponse {
    private UUID id;
    private UUID customerId;
}
