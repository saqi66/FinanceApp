package com.example.financeapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanDto {

    private LocalDateTime date;
    private Double amount;
    private Integer duration;
    private Double payment;

}
