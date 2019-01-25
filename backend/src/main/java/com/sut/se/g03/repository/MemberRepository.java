package com.sut.se.g03.repository;

import com.sut.se.g03.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findByUserName(String userName);
    Optional<Member> findById(Long id);

}
