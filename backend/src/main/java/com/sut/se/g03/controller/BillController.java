package com.sut.se.g03.controller;

import com.sut.se.g03.G03Application;
import com.sut.se.g03.entity.*;
import com.sut.se.g03.repository.*;
import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;
import java.security.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class BillController{

   
    @Autowired private MemberRepository memberRepository;
    @Autowired private BillRepository billRepository;
    @Autowired private BillInfoRepository billInfoRepository;
    @Autowired private PaidStatusRepository paidStatusRepository;
    @Autowired private ContactRepository contactRepository;


    @GetMapping("/Bill")
    public Collection<Bill> bill(){
        return billRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Bill/{billId}")
    public Optional<Bill> takeinBillByid(@PathVariable Long billId ){
        return billRepository.findById(billId);
    }


    @GetMapping("/PaidStatus")
    public Collection<PaidStatus> paidStatus(){
        return  paidStatusRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/PaidStatus/{paidStatusId}")
    public Optional<PaidStatus> takeinPaidStatusByid(@PathVariable Long paidStatusId ){
        return  paidStatusRepository.findById(paidStatusId);
    }

    
    @GetMapping("/bill/Member")
    public Collection<Member> member() {
       return memberRepository.findAll();
    }

    @GetMapping("/bill/Member/{memberId}")
    public Optional<Member> takeinMemberByid(@PathVariable Long memberId) {
        return memberRepository.findById(memberId);
    }

    @PostMapping("/bill/{username}/{billId}/{name}/{tel}/{content}/{price}/{paidStatusId}")
    @Transactional
    public void AddDamageBill(@PathVariable String username,@PathVariable Long billId,@PathVariable String name,@PathVariable String tel,@PathVariable String content,@PathVariable Float price,@PathVariable Long paidStatusId) {
        BillInfo billInfo = new BillInfo();
        Bill bill = billRepository.findById(billId).get();
        Contact contact = new Contact();
        Member member = memberRepository.findByUserName(username);
        PaidStatus paidStatus = paidStatusRepository.findById(paidStatusId).get();
        
        bill.setMember(member);
        billInfo.setBill(bill);
        contact.setBill(bill);
        contact.setName(name);
        contact.setTel(tel);
        billInfo.setContent(content);
        billInfo.setPrice(price);
        bill.setPaidStatus(paidStatus);

        bill.setTotalPrice(price + bill.getTotalPrice());
        billInfoRepository.save(billInfo);
        contactRepository.save(contact);
        billRepository.save(bill);
    } 

    
}