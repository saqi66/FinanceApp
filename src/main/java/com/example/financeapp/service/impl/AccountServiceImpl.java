package com.example.financeapp.service.impl;

import com.example.financeapp.service.AccountService;
import com.example.financeapp.dto.AccountDto;
import com.example.financeapp.dto.exeption.ResourceNotFoundException;
import com.example.financeapp.dto.request.AccountRequest;
import com.example.financeapp.model.Account;
import com.example.financeapp.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
private final AccountRepository accountRepository;

    @Override
    public AccountDto getAccountByAccountId(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("Account", "id", accountId));
        return AccountDto.builder()
                .date(account.getDate())
                .frequency(account.getFrequency())
                .build();
    }

    @Override
    public void saveAccount(AccountRequest accountRequest) {
        Account account = Account.builder()
                .date(accountRequest.getDate())
                .frequency(accountRequest.getFrequency())
                .build();
        accountRepository.save(account);
    }

    @Override
    public void updateAccount(AccountRequest accountRequest) {
        Account account = Account.builder()
                .accountId(accountRequest.getAccountId())
                .date(accountRequest.getDate())
                .frequency(accountRequest.getFrequency())
                .build();
        accountRepository.save(account);
    }

    @Override
    public List<AccountDto> getAll() {

        List<Account> accounts = accountRepository.findAll();
        List<AccountDto> accountDtos = new ArrayList<>();

        for (Account account : accounts) {
            AccountDto accountDto = AccountDto.builder()
                    .date(account.getDate())
                    .frequency(account.getFrequency())
                    .build();

            accountDtos.add(accountDto);
        }

        return accountDtos;
    }

        public void deleteById(Long accountId) {
            Account account = accountRepository.getAccountByAccountId(accountId);
            if (account == null) {
                throw new ResourceNotFoundException("Account", "id", accountId);
            } else {
                accountRepository.deleteById(accountId);
            }
    }
}
