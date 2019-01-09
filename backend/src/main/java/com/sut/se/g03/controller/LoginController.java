package com.sut.se.g03.controller;

import com.sut.se.g03.controller.auth.LoginForm;
import com.sut.se.g03.entity.Member;
import com.sut.se.g03.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @Autowired
	MemberRepository memberRepository;

    @PostMapping("/login")
    public void loginAuth(@RequestBody LoginForm loginForm) throws Exception {
        Member member = memberRepository.findByUserName(loginForm.getUsername());
        String password = member.getPassword();
        if(!EncryptText.validatePassword(loginForm.getPassword(),password)){
            throw new Exception();
        }
        System.out.println("USER LOGIN => "+loginForm.getUsername());
    }

}
