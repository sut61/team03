package com.sut.se.g03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sut.se.g03.entity.*;
import com.sut.se.g03.repository.*;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FixMainController {
    @Autowired private final FixMainRepository fixMainRepository;
    @Autowired private ItemFixRepository itemFixRepository;
    @Autowired private CustomerFixRepository customerFixRepository;
    @Autowired private DatainfoRepository datainfoRepository;
    @Autowired private InstruTypeRepository instruTypeRepository;
    @Autowired private ManagerinfoRepository managerinfoRepository;

    @Autowired
    FixMainController(FixMainRepository fixMainRepository) {
        this.fixMainRepository = fixMainRepository;
    }

    @GetMapping("/FixMains")
    public Collection<FixMain> fixMains() {
        return fixMainRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @GetMapping("/FixMain/{id}")
    public FixMain View(@PathVariable Long id) {
        FixMain F = fixMainRepository.findByFixMainId(id);
        return F;
    }

    @PostMapping("/FixMain/add/{managerName}/{cost}/{itemFixName}/{data}/{instruTypeId}/{name}/{tel}/{email}")
    public FixMain newFixMain(@PathVariable String managerName,@PathVariable Integer cost,@PathVariable String itemFixName, @PathVariable String data,
                              @PathVariable Long instruTypeId, @PathVariable String name, @PathVariable String tel, @PathVariable String email){
        FixMain newFixMain = new FixMain();

        ItemFix newItemFix = new ItemFix();
        newItemFix.setItemFixName(itemFixName);
        itemFixRepository.save(newItemFix);

        Datainfo datainfo = new Datainfo();
        datainfo.setData(data);
        datainfoRepository.save(datainfo);

        CustomerFix newCustomerFix = new CustomerFix();
        newCustomerFix.setCustomerFixName(name);
        newCustomerFix.setTel(tel);
        newCustomerFix.setEmail(email);
        customerFixRepository.save(newCustomerFix);

        InstruType instruType = instruTypeRepository.findByInstruTypeId(instruTypeId);


        Managerinfo managerinfo = new Managerinfo();
        managerinfo.setManagerName(managerName);
        managerinfoRepository.save(managerinfo);

        newFixMain.setManagerinfo(managerinfo);
        newFixMain.setItemFix(newItemFix);
        newFixMain.setInstruType(instruType);
        newFixMain.setDatainfo(datainfo);
        newFixMain.setCustomerFix(newCustomerFix);
        newFixMain.setCost(cost);
        return fixMainRepository.save(newFixMain);
    }
}
