package com.sut.se.g03.controller;

import com.sut.se.g03.controller.auth.LoginForm;
import com.sut.se.g03.entity.Member;
import com.sut.se.g03.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
	MemberRepository memberRepository;

    @PostMapping("/login")
    public ResponseEntity<Object> loginAuth(@RequestBody LoginForm loginForm) throws InvalidKeySpecException, NoSuchAlgorithmException {
        Member member = memberRepository.findByUserName(loginForm.getUsername());
        String password = member.getPassword();
        if(!EncryptText.validatePassword(loginForm.getPassword(),password)){
            logger.info(member.getUserName()+" try to login");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        logger.info("login => "+member.getUserName());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
