package com.etiya.customerservice.dto.individualCustomer;

import com.etiya.customerservice.dto.address.CreateAddressResponse;
import com.etiya.customerservice.dto.billingAccount.CreateBillingAccountRequest;
import com.etiya.customerservice.dto.billingAccount.CreateBillingAccountResponse;
import com.etiya.customerservice.dto.contactMedium.CreateContactMediumResponse;
import com.etiya.customerservice.entity.Address;
import com.etiya.customerservice.entity.BillingAccount;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Date;
import java.util.List;
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
    private boolean status;
    private List<CreateContactMediumResponse> contactMediumList;
    private List<CreateAddressResponse> addressList;
    private List<CreateBillingAccountResponse> billingAccountList;
}
