package com.sut.se.g03.repository;

import com.sut.se.g03.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Optional;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface ClassroomRepository extends JpaRepository<Classroom,Long> {
    Optional<Classroom> findById(Long id);
}