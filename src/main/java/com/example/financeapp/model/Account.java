package com.example.financeapp.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "account")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="account_id")
    private Long accountId;

    @Column(name="district_id")
    private Long districtId;

    @Column(name="frequency")
    private String frequency;

    @Column(name="date")
    private LocalDateTime date;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Loan> loans;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Order> orders;

    @ManyToOne
    @JoinColumn(name = "district_id", referencedColumnName = "district_id",insertable = false, updatable = false)
    private District district;

}
