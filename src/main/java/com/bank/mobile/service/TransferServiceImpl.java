package com.bank.mobile.service;

import com.bank.mobile.client.corebanking.CoreBankingService;
import com.bank.mobile.client.corebanking.dto.TransferInfoDto;
import com.bank.mobile.client.corebanking.dto.TransferRequest;
import com.bank.mobile.client.corebanking.dto.TransferResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class TransferServiceImpl implements TransferService{

    @Inject
    CoreBankingService coreBankingService;

    @Override
    public String nameLookup(String accountNumber) {
        return coreBankingService.lookupCustomerByAccount(accountNumber).getFullName();
    }

    @Override
    public TransferResponse transfer(TransferRequest request, String currentUserNationalCode) {
        return coreBankingService.transfer(request, currentUserNationalCode);
    }

    @Override
    public List<TransferInfoDto> history(String currentUserNationalCode) {
        return coreBankingService.transferHistory(currentUserNationalCode);
    }
}
