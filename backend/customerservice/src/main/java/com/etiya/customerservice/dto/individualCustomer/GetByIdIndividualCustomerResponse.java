package com.etiya.customerservice.dto.individualCustomer;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetByIdIndividualCustomerResponse {
    private UUID customerId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private Date birthday;
    private String motherName;
    private String fatherName;
    private String nationalityId;
}
