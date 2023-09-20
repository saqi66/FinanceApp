package com.example.financeapp.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "district")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="district_id")
    private Long districtId;

    @Column(name="region")
    private String region;

    @Column(name="people")
    private Integer people;

    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
    private List<Account> accounts;

}
