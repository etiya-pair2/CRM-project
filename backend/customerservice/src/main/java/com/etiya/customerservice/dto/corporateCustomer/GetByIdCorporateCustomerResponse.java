package com.etiya.customerservice.dto.corporateCustomer;

import com.etiya.customerservice.dto.address.CreateAddressResponse;
import com.etiya.customerservice.dto.billingAccount.CreateBillingAccountResponse;
import com.etiya.customerservice.dto.contactMedium.CreateContactMediumResponse;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetByIdCorporateCustomerResponse {
    private String companyName;
    private String taxNo;
    private List<CreateContactMediumResponse> contactMediumList;
    private List<CreateAddressResponse> addressList;
    private List<CreateBillingAccountResponse> billingAccountList;
}
