package com.etiya.customerservice.rules;

import com.etiya.customerservice.core.configuration.exceptions.type.BusinessException;
import com.etiya.customerservice.dto.individualCustomer.CreateIndividualCustomerRequest;
import com.etiya.customerservice.mernis.RISKPSPublicSoap;
import com.etiya.customerservice.repository.IndividualCustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;

@Component
@RequiredArgsConstructor
public class IndCustBusinessRules {

    private final IndividualCustomerRepository indCustRepository;

    @SneakyThrows
    public void checkMernis(CreateIndividualCustomerRequest request)  {
        RISKPSPublicSoap client = new RISKPSPublicSoap();
        String fullName = request.getFirstName();
        if (request.getMiddleName() != null && !request.getMiddleName().isEmpty()) {
            fullName += " " + request.getMiddleName();
        }
        boolean isRealPerson = client.TCKimlikNoDogrula(Long.valueOf(request.getNationalityId()),fullName,request.getLastName(),request.getBirthday().getYear());
        if(!isRealPerson){
            throw new BusinessException("Müşterinin Kimlik Bilgileri Doğrulanamadı!");
        }
    }

    public void checkIndCustExist(String natId){
        boolean exists = indCustRepository.existsByNationalityId(natId);
        if (exists) {
            throw new BusinessException("Bu Müşteri Zaten Kayıtlı!");
        }

    }
}
