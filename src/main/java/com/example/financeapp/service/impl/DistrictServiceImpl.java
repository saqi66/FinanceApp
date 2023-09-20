package com.example.financeapp.service.impl;

import com.example.financeapp.service.DistrictService;
import com.example.financeapp.dto.DistrictDto;
import com.example.financeapp.dto.exeption.ResourceNotFoundException;
import com.example.financeapp.dto.request.DistrictRequest;
import com.example.financeapp.model.District;
import com.example.financeapp.repository.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DistrictServiceImpl implements DistrictService {

    private final DistrictRepository districtRepository;

    public DistrictDto getDistrictByDistrictId(Long districtId) {
        District district = districtRepository.findById(districtId)
                .orElseThrow(() -> new ResourceNotFoundException("District", "id", districtId));
        return DistrictDto.builder()
                .region(district.getRegion())
                .people(district.getPeople())
                .build();
    }

    public void saveDistrict(DistrictRequest districtRequest) {
        District district = District.builder()
                .region(districtRequest.getRegion())
                .people(districtRequest.getPeople())
                .build();
        districtRepository.save(district);
    }

    public void updateDistrict(DistrictRequest districtRequest) {
        District district = District.builder()
                .districtId(districtRequest.getDistrictId())
                .region(districtRequest.getRegion())
                .people(districtRequest.getPeople())
                .build();
        districtRepository.save(district);
    }

    public List<DistrictDto> getAll() {
        List<District> districts = districtRepository.findAll();
        List<DistrictDto> districtDtos = new ArrayList<>();
        for (District district : districts) {
            DistrictDto districtDto = DistrictDto.builder()
                    .region(district.getRegion())
                    .people(district.getPeople())
                    .build();
            districtDtos.add(districtDto);
        }
        return districtDtos;
    }

    public void deleteById(Long districtId) {
        District district = districtRepository.findById(districtId)
                .orElseThrow(() -> new ResourceNotFoundException("District", "id", districtId));
        districtRepository.deleteById(districtId);
    }
}
