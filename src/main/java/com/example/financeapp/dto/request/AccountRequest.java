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
public class AccountRequest {

    private Long accountId;
    private Long districtId;
    private String frequency;
    private LocalDateTime date;


}
