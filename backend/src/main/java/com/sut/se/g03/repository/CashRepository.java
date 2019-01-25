package com.sut.se.g03.repository;

import com.sut.se.g03.entity.Cash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestController
@CrossOrigin(origins = "http://localhost:4200")
public interface CashRepository extends JpaRepository<Cash,Long> {

}
