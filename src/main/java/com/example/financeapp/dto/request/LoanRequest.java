package com.example.financeapp.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanRequest {

    private Long loanId;
    private Long accountId;
    private LocalDateTime date;
    private Double amount;
    private Integer duration;
    private Double payment;


}
