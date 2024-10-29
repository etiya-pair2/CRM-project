package com.etiya.customerservice.rules;

import com.etiya.customerservice.core.configuration.exceptions.type.BusinessException;
import com.etiya.customerservice.dto.individualCustomer.CreateIndividualCustomerRequest;
import com.etiya.customerservice.entity.IndividualCustomer;
import com.etiya.customerservice.mernis.RISKPSPublicSoap;
import com.etiya.customerservice.repository.CustomerRepository;
import com.etiya.customerservice.repository.IndividualCustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class IndCustBusinessRules {

    private final IndividualCustomerRepository indCustRepository;

    private final CustomerRepository customerRepository;

    @SneakyThrows
    public void checkMernis(CreateIndividualCustomerRequest request)  {
        RISKPSPublicSoap client = new RISKPSPublicSoap();
        String fullName = request.getFirstName();
        if (request.getMiddleName() != null && !request.getMiddleName().isEmpty()) {
            fullName += " " + request.getMiddleName();
        }
        boolean isRealPerson = client.TCKimlikNoDogrula(Long.valueOf(request.getNationalityId()),fullName,request.getLastName(), request.getBirthday().getYear());
        if(!isRealPerson){
            throw new BusinessException("Müşterinin Kimlik Bilgileri Doğrulanamadı!");
        }
    }

    /**
     * Belirtilen vatandaşlık numarasına sahip bireysel müşteri var mı kontrol eder.
     *
     * @param natId Müşterinin vatandaşlık numarası
     * @throws BusinessException Eğer müşteri zaten kayıtlıysa
     */
    public void checkIndCustExist(String natId){
        boolean exists = indCustRepository.existsByNationalityId(natId);
        if (exists) {
            throw new BusinessException("Bu Müşteri Zaten Kayıtlı!");
        }
    }

    /**
     * Belirtilen UUID'ye sahip müşteri var mı kontrol eder.
     *
     * @param id Müşterinin UUID'si
     * @throws BusinessException Eğer müşteri bulunamazsa
     */
    public IndividualCustomer checkCustomerExist(UUID id){
        return indCustRepository.findById(id).orElseThrow(() -> new BusinessException("Müşteri Bulunamadı"));
    }

    public void checkDeletedCustExist(UUID id){
        if(!customerRepository.findById(id).orElseThrow().getStatus()){
            throw new BusinessException("Bu Kullanıcı Zaten Silinmiş");
        }
    }
}
