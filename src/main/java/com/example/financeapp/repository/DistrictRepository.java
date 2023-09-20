package com.example.financeapp.repository;

import com.example.financeapp.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {

    District getDistrictByDistrictId(Long districtId);

}
