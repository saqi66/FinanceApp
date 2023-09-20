package com.example.financeapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "loan")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data


public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="loan_id")
    private Long loanId;

    @Column(name="account_id")
    private Long accountId;

    @Column(name="date")
    private LocalDateTime date;

    @Column(name="amount")
    private Double amount;

    @Column(name="duration")
    private Integer duration;

    @Column(name="payment")
    private Double payment;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_id",insertable = false, updatable = false)
    private Account account;

}
