package com.sut.se.g03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.sut.se.g03.entity.InstruType;

@RepositoryRestResource
public interface InstruTypeRepository extends JpaRepository<InstruType, Long> {
    InstruType findByInstruTypeId(Long instruTypeId);
}
