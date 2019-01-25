package com.sut.se.g03.controller;

import org.springframework.web.bind.annotation.*;
import com.sut.se.g03.entity.*;
import com.sut.se.g03.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProvinceController {
    @Autowired private final ProvinceRepository provinceRepository;
    @Autowired private DistrictRepository districtRepository;

    ProvinceController(ProvinceRepository provinceRepository) {

        this.provinceRepository = provinceRepository;
    }
    @GetMapping("/Provinces")
    public Collection<Province> provinces() {
        return provinceRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/District/{provinceId}")
    public Province province(@PathVariable long provinceId) {
        Province province = provinceRepository.findById(provinceId);
        return province;
    }

}
