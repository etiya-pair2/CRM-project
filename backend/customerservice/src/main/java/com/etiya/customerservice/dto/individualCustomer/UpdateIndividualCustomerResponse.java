package com.etiya.customerservice.dto.individualCustomer;

import com.etiya.customerservice.dto.address.CreateAddressResponse;
import com.etiya.customerservice.dto.billingAccount.CreateBillingAccountResponse;
import com.etiya.customerservice.dto.contactMedium.CreateContactMediumResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateIndividualCustomerResponse {
    private UUID customerId;
    private String nationalityId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private LocalDate birthday;
    private String motherName;
    private String fatherName;


}
