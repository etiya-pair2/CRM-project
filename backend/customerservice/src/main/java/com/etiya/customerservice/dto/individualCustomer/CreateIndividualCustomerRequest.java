package com.etiya.customerservice.dto.individualCustomer;

import com.etiya.customerservice.dto.address.CreateAddressRequest;
import com.etiya.customerservice.dto.address.CreateAddressResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateIndividualCustomerRequest {


        @NotBlank(message = "TC Kimlik Numarası boş bırakılamaz.")
        @Size(min = 11, max = 11, message = "TC Kimlik Numarası 11 haneli olmalıdır.")
        @Pattern(regexp = "^[0-9]+$", message = "TC Kimlik Numarası sadece rakamlardan oluşmalıdır.")
        private String nationalityId;

        @NotBlank(message = "İsim boş bırakılamaz.")
        @Size(min = 3, message = "İsim en az 3 harfli olmalıdır.")
        private String firstName;

//        @Size(min = 3, message = "Orta isim en az 3 harfli olmalıdır.")
        private String middleName;
//
        @NotBlank(message = "Soyisim boş bırakılamaz.")
        @Size(min = 2, message = "Soyisim en az 2 harfli olmalıdır.")
        private String lastName;

        @NotBlank(message = "Cinsiyet boş bırakılamaz.")
        private String gender;

//        @NotNull(message = "Doğum tarihi boş bırakılamaz.")
//        @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19|20)\\d\\d$",
//                message = "Doğum tarihi gg/aa/yyyy formatında olmalıdır.")
        private LocalDate birthday;

//        @NotBlank(message = "Anne adı boş bırakılamaz.")
//        @Size(min = 3, message = "Anne adı en az 3 harfli olmalıdır.")
        private String motherName;

//        @NotBlank(message = "Baba adı boş bırakılamaz.")
//        @Size(min = 3, message = "Baba adı en az 3 harfli olmalıdır.")
        private String fatherName;


    }


