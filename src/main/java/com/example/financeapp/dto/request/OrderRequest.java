package com.example.financeapp.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    private Long ordersId;
    private Long accountId;
    private String bankTo;
    private String accountTo;
    private Double amount;
    private String type;


}
