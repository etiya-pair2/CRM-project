package com.etiya.customerservice.dto.customer;
import com.etiya.customerservice.dto.address.CreateAddressRequest;
import com.etiya.customerservice.dto.billingAccount.CreateBillingAccountRequest;
import com.etiya.customerservice.dto.contactMedium.CreateContactMediumRequest;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateCustomerRequest {

    private Date createdDate;
    private Date updatedDate;
    private boolean status;

}
