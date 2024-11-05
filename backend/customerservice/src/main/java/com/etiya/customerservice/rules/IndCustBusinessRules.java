package com.etiya.customerservice.rules;

import com.etiya.customerservice.dto.individualCustomer.CreateIndividualCustomerRequest;
import com.etiya.customerservice.entity.IndividualCustomer;
import com.etiya.customerservice.mernis.RISKPSPublicSoap;
import com.etiya.customerservice.repository.CustomerRepository;
import com.etiya.customerservice.repository.IndividualCustomerRepository;
import io.github.sabaurgup.exceptions.type.BusinessException;
import io.github.sabaurgup.services.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class IndCustBusinessRules {

    private final IndividualCustomerRepository indCustRepository;

    private final CustomerRepository customerRepository;

    private final MessageService messageServices;

    @SneakyThrows
    public void checkMernis(CreateIndividualCustomerRequest request)  {
        RISKPSPublicSoap client = new RISKPSPublicSoap();
        String fullName = request.getFirstName();
        if (request.getMiddleName() != null && !request.getMiddleName().isEmpty()) {
            fullName += " " + request.getMiddleName();
        }
        boolean isRealPerson = client.TCKimlikNoDogrula(Long.valueOf(request.getNationalityId()),fullName,
                request.getLastName(), request.getBirthday().getYear());
        if(!isRealPerson){
            throw new BusinessException(messageServices.getMessage("credentionals.verified"));
        }
    }

    public void checkIndCustExist(String natId){
        Optional<IndividualCustomer> individualCustomer = indCustRepository.findByNationalityId(natId);
        boolean checkNatId = indCustRepository.existsByNationalityId(natId);
        if(individualCustomer.isPresent()) {
            if (individualCustomer.get().getStatus() && checkNatId) {
                throw new BusinessException("Bu Müşteri Zaten Kayıtlı!");
            }
        }
    }

    public IndividualCustomer checkCustomerExist(UUID id){
        return indCustRepository.findById(id).orElseThrow(() -> new BusinessException("Müşteri Bulunamadı"));
    }

    public void checkDeletedCustExist(UUID id){
        if(!customerRepository.findById(id).orElseThrow().getStatus()){
            throw new BusinessException("Bu Kullanıcı Zaten Silinmiş");
        }
    }
}
