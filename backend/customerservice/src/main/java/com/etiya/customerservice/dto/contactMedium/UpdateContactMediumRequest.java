package com.etiya.customerservice.dto.contactMedium;

import lombok.*;

import java.util.UUID;
@Data
public class UpdateContactMediumRequest {
    private UUID Id;
    private String email;
    private String homePhone;
    private String mobilePhone;
    private String fax;
}
