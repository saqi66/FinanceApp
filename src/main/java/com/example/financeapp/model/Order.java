package com.example.financeapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id")
    private Long ordersId;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "bank_to")
    private String bankTo;

    @Column(name = "account_to")
    private String accountTo;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_id", insertable = false, updatable = false)
    private Account account;

}
