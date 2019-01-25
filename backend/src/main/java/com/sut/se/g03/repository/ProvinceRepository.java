package com.sut.se.g03.repository;
import com.sut.se.g03.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProvinceRepository extends JpaRepository<Province, Long>  {
    Province findById(long provinceId);
}
