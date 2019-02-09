package com.sut.se.g03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.sut.se.g03.entity.CustomerFix;

@RepositoryRestResource
public interface CustomerFixRepository extends JpaRepository<CustomerFix, Long> {
    CustomerFix findByCustomerFixId(Long customerFixId);
}
