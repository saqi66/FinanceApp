package com.example.financeapp.service;

import com.example.financeapp.dto.AccountDto;
import com.example.financeapp.dto.request.AccountRequest;

import java.util.List;

public interface AccountService {

    AccountDto getAccountByAccountId(Long accountId);

    void saveAccount (AccountRequest accountRequest);

    void updateAccount (AccountRequest accountRequest);

    List<AccountDto> getAll();

    void deleteById(Long accountId);

}
