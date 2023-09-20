package com.example.financeapp.service;

import com.example.financeapp.dto.LoanDto;
import com.example.financeapp.dto.request.LoanRequest;

import java.util.List;

public interface LoanService {

    LoanDto getLoanByLoanId(Long loanId);

    void saveLoan (LoanRequest loanRequest);

    void updateLoan (LoanRequest loanRequest);

    List<LoanDto> getAll();

    void deleteById(Long loanId);



}
