package com.sut.se.g03.controller;

import org.springframework.web.bind.annotation.*;
import com.sut.se.g03.entity.Datainfo;

import org.springframework.beans.factory.annotation.Autowired;
import com.sut.se.g03.repository.DatainfoRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DatainfoController {
    @Autowired private final DatainfoRepository datainfoRepository;

    DatainfoController(DatainfoRepository datainfoRepository) {
        this.datainfoRepository = datainfoRepository;
    }
    @GetMapping("/Datainfos")
    public Collection<Datainfo> datainfos() {
        return datainfoRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @PostMapping("/Datainfo/add/{data}")
    public Datainfo newDatainfo(@PathVariable String data){
        Datainfo datainfo = new Datainfo();
        datainfo.setData(data);

        return datainfoRepository.save(datainfo);
    }
}
