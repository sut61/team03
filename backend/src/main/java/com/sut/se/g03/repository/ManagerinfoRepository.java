package com.sut.se.g03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.sut.se.g03.entity.Managerinfo;

@RepositoryRestResource
public interface ManagerinfoRepository extends JpaRepository<Managerinfo, Long> {
    Managerinfo findByManagerinfoId(Long managerinfoId);
}
