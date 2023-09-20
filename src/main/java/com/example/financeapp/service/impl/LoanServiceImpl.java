package com.example.financeapp.service.impl;

import com.example.financeapp.service.LoanService;
import com.example.financeapp.dto.LoanDto;
import com.example.financeapp.dto.exeption.ResourceNotFoundException;
import com.example.financeapp.dto.request.LoanRequest;
import com.example.financeapp.model.Loan;
import com.example.financeapp.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    public LoanDto getLoanByLoanId(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan", "id", loanId));
        return LoanDto.builder()
                .date(loan.getDate())
                .amount(loan.getAmount())
                .duration(loan.getDuration())
                .payment(loan.getPayment())
                .build();
    }

    public void saveLoan(LoanRequest loanRequest) {
        Loan loan = Loan.builder()
                .date(loanRequest.getDate())
                .amount(loanRequest.getAmount())
                .duration(loanRequest.getDuration())
                .payment(loanRequest.getPayment())
                .build();
        loanRepository.save(loan);
    }

    public void updateLoan(LoanRequest loanRequest) {
        Loan loan = Loan.builder()
                .loanId(loanRequest.getLoanId())
                .accountId(loanRequest.getAccountId())
                .date(loanRequest.getDate())
                .amount(loanRequest.getAmount())
                .duration(loanRequest.getDuration())
                .payment(loanRequest.getPayment())
                .build();
        loanRepository.save(loan);
    }

    public List<LoanDto> getAll() {
        List<Loan> loans = loanRepository.findAll();
        List<LoanDto> loanDtos = new ArrayList<>();
        for (Loan loan : loans) {
            LoanDto loanDto = LoanDto.builder()
                    .date(loan.getDate())
                    .amount(loan.getAmount())
                    .duration(loan.getDuration())
                    .payment(loan.getPayment())
                    .build();
            loanDtos.add(loanDto);
        }
        return loanDtos;
    }

    public void deleteById(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan", "id", loanId));
        loanRepository.deleteById(loanId);
    }
}
