package com.example.financeapp.service;

import com.example.financeapp.dto.DistrictDto;
import com.example.financeapp.dto.request.DistrictRequest;

import java.util.List;

public interface DistrictService {

    DistrictDto getDistrictByDistrictId(Long districtId);

    void saveDistrict (DistrictRequest districtRequest);

    void updateDistrict (DistrictRequest districtRequest);

    List<DistrictDto> getAll();

    void deleteById(Long districtId);


}
