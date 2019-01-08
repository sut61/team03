package com.sut.se.g03;

import com.sut.se.g03.entity.Member;
import com.sut.se.g03.repository.MemberRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class G03Application {

	public static void main(String[] args) {
		SpringApplication.run(G03Application.class, args);
	}

	@Bean
	ApplicationRunner init(MemberRepository memberRepository){
		return args -> {
			createNewUser("1234","zzzz",memberRepository);
		};
	}

	private void createNewUser(String plainPassword,String userName,
							   MemberRepository memberRepository) throws Exception {
		memberRepository.save(new Member(userName,plainPassword));
	}

}

