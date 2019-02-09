package com.sut.se.g03.controller;

import org.springframework.web.bind.annotation.*;


import org.springframework.beans.factory.annotation.Autowired;
import com.sut.se.g03.entity.Managerinfo;
import com.sut.se.g03.repository.ManagerinfoRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ManagerinfoController {
    @Autowired private final ManagerinfoRepository managerinfoRepository;

    ManagerinfoController(ManagerinfoRepository managerinfoRepository) {
        this.managerinfoRepository = managerinfoRepository;
    }
    @GetMapping("/Managerinfos")
    public Collection<Managerinfo> managerinfos() {
        return managerinfoRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @PostMapping("/Managerinfo/add/{managerName}")
    public Managerinfo newCustomer(@PathVariable String managerName){
        Managerinfo managerinfo = new Managerinfo();
        managerinfo.setManagerName(managerName);

        return managerinfoRepository.save(managerinfo);
    }
}
