package com.sut.se.g03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.sut.se.g03.entity.Datainfo;

@RepositoryRestResource
public interface DatainfoRepository extends JpaRepository<Datainfo, Long> {
    Datainfo findByDatainfoId(Long datainfoId);
}
