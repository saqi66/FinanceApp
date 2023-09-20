package com.example.financeapp.controller;

import com.example.financeapp.service.DistrictService;
import com.example.financeapp.dto.DistrictDto;
import com.example.financeapp.dto.request.DistrictRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/district")
public class DistrictController {

    final DistrictService districtService;

    @GetMapping(value = "/districtList")
    public List<DistrictDto> getDistrictInfo() {
        return districtService.getAll();
    }

    @GetMapping(value = "/getDistrictById/{id}")
    public DistrictDto getDistrictById(@PathVariable(value = "id") Long districtId) {
        return districtService.getDistrictByDistrictId(districtId);
    }

    @PostMapping(value = "/saveDistrict")
    public void saveDistrict(@RequestBody DistrictRequest districtRequest) {
        districtService.saveDistrict(districtRequest);
    }

    @PutMapping(value = "/updateDistrict")
    public void updateDistrict(@RequestBody DistrictRequest districtRequest) {
        districtService.updateDistrict(districtRequest);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id") Long districtId) {
        districtService.deleteById(districtId);
    }
}
