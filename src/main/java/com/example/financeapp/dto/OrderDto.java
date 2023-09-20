package com.example.financeapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private String bankTo;
    private String accountTo;
    private Double amount;
    private String type;


}
