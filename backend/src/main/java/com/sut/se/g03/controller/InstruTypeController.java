package com.sut.se.g03.controller;

import org.springframework.web.bind.annotation.*;
import com.sut.se.g03.entity.InstruType;

import org.springframework.beans.factory.annotation.Autowired;
import com.sut.se.g03.repository.InstruTypeRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class InstruTypeController {
    @Autowired private final InstruTypeRepository instruTypeRepository;

    InstruTypeController(InstruTypeRepository instruTypeRepository) {
        this.instruTypeRepository = instruTypeRepository;
    }
    @GetMapping("/InstruTypes")
    public Collection<InstruType> instruTypes() {
        return instruTypeRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @PostMapping("/InstruTypes/add/{instumentType}")
    public InstruType newCustomer(@PathVariable String instumentType){
        InstruType instruType = new InstruType();
        instruType.setInstumentType(instumentType);

        return instruTypeRepository.save(instruType);
    }
}
