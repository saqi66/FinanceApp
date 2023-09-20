package com.example.financeapp.controller;

import com.example.financeapp.service.AccountService;
import com.example.financeapp.dto.AccountDto;
import com.example.financeapp.dto.request.AccountRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/account")
public class AccountController {

    final AccountService accountService;

    @GetMapping(value = "/accountList")
    public List<AccountDto> getAccountInfo() {
        return accountService.getAll();
    }

    @GetMapping(value = "/getAccountById/{id}")
    public AccountDto getAccountById(@PathVariable(value = "id") Long accountId) {
        return accountService.getAccountByAccountId(accountId);
    }

    @PostMapping(value = "/saveAccount")
    public void saveAccount(@RequestBody AccountRequest accountRequest) {
        accountService.saveAccount(accountRequest);
    }

    @PutMapping(value = "/updateAccount")
    public void updateAccount(@RequestBody AccountRequest accountRequest) {
        accountService.updateAccount(accountRequest);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id") Long accountId) {
        accountService.deleteById(accountId);
    }
}
