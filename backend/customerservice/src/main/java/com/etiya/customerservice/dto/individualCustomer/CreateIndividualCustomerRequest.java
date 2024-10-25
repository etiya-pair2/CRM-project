package com.etiya.customerservice.dto.individualCustomer;

import com.etiya.customerservice.dto.address.CreateAddressRequest;
import com.etiya.customerservice.dto.address.CreateAddressResponse;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateIndividualCustomerRequest {

    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private Date birthday;
    private String motherName;
    private String fatherName;
    private String nationalityId;
    private boolean status;
}
