package com.bank.mobile.resource;

import com.bank.mobile.client.corebanking.dto.TransferInfoDto;
import com.bank.mobile.client.corebanking.dto.TransferRequest;
import com.bank.mobile.client.corebanking.dto.TransferResponse;
import com.bank.mobile.dto.ResponseDto;
import com.bank.mobile.service.TransferService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/api/bank/mobile/transfers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TransferResource {

    @Inject
    TransferService transferService;

    @GET
    @Path("/name-lookup/{account-number}")
    public ResponseDto<String> nameLookup(@PathParam("account-number") String accountNumber) {
        return new ResponseDto<>(
                transferService.nameLookup(accountNumber)
        );
    }

    @POST
    public ResponseDto<TransferResponse> transfer(TransferRequest request,
                                                  @HeaderParam("X-National-Code") String currentUserNationalCode) {
        return new ResponseDto<>(
                transferService.transfer(request, currentUserNationalCode)
        );
    }

    @GET
    @Path("/history")
    public ResponseDto<List<TransferInfoDto>> history(@HeaderParam("X-National-Code") String currentUserNationalCode) {
        return new ResponseDto<>(
                transferService.history(currentUserNationalCode)
        );
    }
}
