package com.sut.se.g03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.sut.se.g03.entity.FixMain;

@RepositoryRestResource
public interface FixMainRepository extends JpaRepository<FixMain, Long> {
    FixMain findByFixMainId(Long fixMainId);
}
