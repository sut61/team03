package com.sut.se.g03.repository;

import com.sut.se.g03.entity.CreditType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@RepositoryRestController
@CrossOrigin(origins = "http://localhost:4200")
public interface CreditTypeRepository extends JpaRepository<CreditType,Long> {
    Optional<CreditType> findById(Long id);

}
