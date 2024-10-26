package com.etiya.customerservice.dto.contactMedium;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetAllContactMediumResponse {
    private UUID id;
    private UUID customerId;
    private String email;
    private String homePhone;
    private String mobilePhone;
    private String fax;
}
