package com.bank.mobile.service;

import com.bank.mobile.client.corebanking.dto.TransferInfoDto;
import com.bank.mobile.client.corebanking.dto.TransferRequest;
import com.bank.mobile.client.corebanking.dto.TransferResponse;

import java.util.List;

public interface TransferService {
    String nameLookup(String accountNumber);

    TransferResponse transfer(TransferRequest request, String currentUserNationalCode);

    List<TransferInfoDto> history(String currentUserNationalCode);
}
