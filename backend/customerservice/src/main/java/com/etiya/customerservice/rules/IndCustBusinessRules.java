package com.etiya.customerservice.rules;

import com.etiya.customerservice.core.configuration.exceptions.type.BusinessException;
import com.etiya.customerservice.dto.individualCustomer.CreateIndividualCustomerRequest;
import com.etiya.customerservice.mernis.RISKPSPublicSoap;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;

@Component
@RequiredArgsConstructor
public class IndCustBusinessRules {

    @SneakyThrows
    public void checkMernis(CreateIndividualCustomerRequest request)  {
        LocalDate localDate = request.getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        RISKPSPublicSoap client = new RISKPSPublicSoap();
        String fullName = request.getFirstName();
        if (request.getMiddleName() != null && !request.getMiddleName().isEmpty()) {
            fullName += " " + request.getMiddleName();
        }
        boolean isRealPerson = client.TCKimlikNoDogrula(Long.valueOf(request.getNationalityId()),fullName,request.getLastName(),localDate.getYear());
        if(!isRealPerson){
            throw new BusinessException("Müşterinin Kimlik Bilgileri Doğrulanamadı");
        }
    }
}
