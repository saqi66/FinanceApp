package com.example.financeapp.controller;

import com.example.financeapp.service.LoanService;
import com.example.financeapp.dto.LoanDto;
import com.example.financeapp.dto.request.LoanRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/loan")
public class LoanController {

    final LoanService loanService;

    @GetMapping(value = "/loanList")
    public List<LoanDto> getLoanInfo() {
        return loanService.getAll();
    }

    @GetMapping(value = "/getLoanById/{id}")
    public LoanDto getLoanById(@PathVariable(value = "id") Long loanId) {
        return loanService.getLoanByLoanId(loanId);
    }

    @PostMapping(value = "/saveLoan")
    public void saveLoan(@RequestBody LoanRequest loanRequest) {
        loanService.saveLoan(loanRequest);
    }

    @PutMapping(value = "/updateLoan")
    public void updateLoan(@RequestBody LoanRequest loanRequest) {
        loanService.updateLoan(loanRequest);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id") Long loanId) {
        loanService.deleteById(loanId);
    }
}
