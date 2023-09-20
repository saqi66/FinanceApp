package com.example.financeapp.repository;

import com.example.financeapp.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    Loan getLoanByLoanId(Long loanId);

}
