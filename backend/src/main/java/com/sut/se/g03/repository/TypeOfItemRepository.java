package com.sut.se.g03.repository;

import com.sut.se.g03.entity.TypeOfItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface TypeOfItemRepository extends JpaRepository<TypeOfItem,Long> {
}
