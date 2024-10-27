package com.etiya.customerservice.dto.billingAccount;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateBillingAccountRequest {

    @NotNull
    private UUID customerId;

    @NotNull
    private UUID addressId;

    @NotBlank(message = "Açıklama Boş Bırakılamaz!")
    private String description;

    @NotBlank(message = "Hesap İsmi Boş Bırakılamaz!")
    private String accountName;

    @NotBlank(message = "Hesap Numarası Boş Bırakılamaz!")
    private String accountNumber;

    @NotBlank(message = "Hesap Tipi Boş Bırakılamaz!")
    private String accountType;
    //TODO: bu ne işe yarıyor?
    private String action;
}
