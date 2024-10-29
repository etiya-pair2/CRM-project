package com.etiya.customerservice.dto.individualCustomer;

import com.etiya.customerservice.dto.address.CreateAddressRequest;
import com.etiya.customerservice.dto.address.CreateAddressResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Anne adı boş bırakılamaz.")
    @Size(min = 3, message = "Anne adı en az 3 harfli olmalıdır.")
    private String motherName;

    @NotBlank(message = "Baba adı boş bırakılamaz.")
    @Size(min = 3, message = "Baba adı en az 3 harfli olmalıdır.")
    private String fatherName;

    @NotBlank(message = "Cinsiyet boş bırakılamaz.")
    private String gender;


}
