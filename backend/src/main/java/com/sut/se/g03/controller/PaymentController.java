package com.sut.se.g03.controller;

import com.sut.se.g03.entity.*;
import com.sut.se.g03.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PaymentController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private CreditTypeRepository creditTypeRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private PaidStatusRepository paidStatusRepository;
    @Autowired
    private CashRepository cashRepository;
    @Autowired
    private MemberInfoRepository memberInfoRepository;
    //Bill
    @GetMapping("pay/bill")
    public Collection<Bill> Bill() {
        return billRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("pay/bill/{Bid}")
    public Optional<Bill> takeinBillByid(@PathVariable Long Bid) {
        return billRepository.findById(Bid);
    }

    //CreditType
    @GetMapping("pay/creditType")
    public Collection<CreditType> Credit() {
        return creditTypeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("pay/creditType/{Cid}")
    public Optional<CreditType> takeinCreditTypeByid(@PathVariable Long Cid) {
        return creditTypeRepository.findById(Cid);
    }

    //Member
    @GetMapping("pay/member")
    public Collection<Member> Member() {
        return memberRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("pay/member/{Mid}")
    public Optional<Member> takeinMemberByid(@PathVariable Long Mid) {
        return memberRepository.findById(Mid);
    }
    //Payment
    @GetMapping("pay/payment")
    public Collection<Payment> Payment(){
        return paymentRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("pay/payment/{Pid}")
    public Optional<Payment> takeinPaymentByid(@PathVariable Long Pid){
        return paymentRepository.findById(Pid);
    }

    @PostMapping("pay/payment/{timeSelect}/{price}/{receive}/{Cid}/{Iid}/{Bid}/{Sid}")
    public Payment createPayment(@PathVariable Long Cid , @PathVariable Date timeSelect, @PathVariable float price, @PathVariable String receive, @PathVariable Long Iid , @PathVariable Long Bid, @PathVariable Long Sid) {
        CreditType creditType = creditTypeRepository.findById(Cid).get();
        MemberInfo memberInfo = memberInfoRepository.findById(Iid).get();
        Bill bill = billRepository.findById(Bid).get();
        PaidStatus paidStatus = paidStatusRepository.findById(Sid).get();

        Payment payment = new Payment();
        payment.setDate(timeSelect);
        payment.setPrice(price);
        payment.setReceive(receive);
        payment.setCredit(creditType);
        payment.setMem(memberInfo);
        payment.setBill(bill);
        payment.setPaidStatus(paidStatus);
        paymentRepository.save(payment);

        return payment;
    }

    //Status
    @GetMapping("pay/status")
    public Collection<PaidStatus> PaidStatus() {
        return paidStatusRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("pay/status/{Sid}")
    public Optional<PaidStatus> takeinStatusByid(@PathVariable Long Sid) {
        return paidStatusRepository.findById(Sid);
    }


    //cash
    @GetMapping("pay/cash")
    public Collection<Cash> Cash() {
        return cashRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("pay/cash/{Hid}")
    public Optional<Cash> takeinCashByid(@PathVariable Long Hid) {
        return cashRepository.findById(Hid);
    }

    @PostMapping("pay/cash/{cashreceive}/{price}/{Bid}/{Iid}/{Sid}")
    public Cash createCash(@PathVariable String cashreceive , @PathVariable float price , @PathVariable Long Bid , @PathVariable Long Iid , @PathVariable Long Sid){
        MemberInfo memberInfo = memberInfoRepository.findById(Iid).get();
        Bill bill = billRepository.findById(Bid).get();
        PaidStatus paidStatus = paidStatusRepository.findById(Sid).get();

        Cash c = new Cash();
        c.setCashreceive(cashreceive);
        c.setCashprice(price);
        c.setBill(bill);
        c.setMem(memberInfo);
        c.setPaidStatus(paidStatus);
        cashRepository.save(c);
        return c;

    }
    //MemberInfo
    @GetMapping("pay/memberinfo")
    public Collection<MemberInfo> MemberInfo() {
        return memberInfoRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("pay/memberinfo/{Iid}")
    public Optional<MemberInfo> takeinInfoByid(@PathVariable Long Iid) {
        return memberInfoRepository.findById(Iid);
    }
}
