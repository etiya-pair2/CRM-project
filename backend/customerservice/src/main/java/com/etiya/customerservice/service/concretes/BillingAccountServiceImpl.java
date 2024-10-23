package com.etiya.customerservice.service.concretes;

import com.etiya.customerservice.dto.billingAccount.*;
import com.etiya.customerservice.entity.BillingAccount;
import com.etiya.customerservice.mapper.BillingAccountMapper;
import com.etiya.customerservice.repository.BillingAccountRepository;
import com.etiya.customerservice.service.abstracts.BillingAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BillingAccountServiceImpl implements BillingAccountService {

    private final BillingAccountRepository billingAccountRepository;

    @Override
    public CreateBillingAccountResponse create(CreateBillingAccountRequest request) {
        BillingAccount billingAccount = BillingAccountMapper.INSTANCE.billingAccountFromCreateRequest(request);
        billingAccountRepository.save(billingAccount);
        return BillingAccountMapper.INSTANCE.BillingAccountFromCreateResponse(billingAccount);
    }

    @Override
    public UpdateBillingAccountResponse update(UpdateBillingAccountRequest request) {
        BillingAccount billingAccount = BillingAccountMapper.INSTANCE.billingAccountFromUpdateRequest(request);
        billingAccountRepository.save(billingAccount);
        return BillingAccountMapper.INSTANCE.BillingAccountFromUpdateResponse(billingAccount);
    }

    @Override
    public DeleteBillingAccountResponse delete(UUID id) {
        BillingAccount billingAccount= billingAccountRepository.findById(id).orElseThrow(()->
                new RuntimeException("Billing Account not found with ID:"  + id));
        return BillingAccountMapper.INSTANCE.BillingAccountFromDeleteResponse(billingAccount);
    }

    @Override
    public List<GetAllBillingAccountResponse> getAll() {
        List<BillingAccount> billingAccounts=billingAccountRepository.findAll();
        return BillingAccountMapper.INSTANCE.getAll(billingAccounts);
    }

    @Override
    public GetByIdBillingAccountResponse getById(UUID id) {
        BillingAccount billingAccount= billingAccountRepository.findById(id).orElseThrow(()->
                new RuntimeException("Billing Account not found with ID:"  + id));
        return BillingAccountMapper.INSTANCE.getBillingAccountById(billingAccount);
    }
}
