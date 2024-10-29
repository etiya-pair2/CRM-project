package com.etiya.customerservice.dto.individualCustomer;

import com.etiya.customerservice.dto.address.CreateAddressRequest;
import com.etiya.customerservice.dto.address.CreateAddressResponse;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateIndividualCustomerRequest {
    private UUID customerId;
    private String gender;
    private Date birthday;
    private String motherName;
    private String fatherName;
    private List<CreateAddressRequest> addressList;
}
