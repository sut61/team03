package com.sut.se.g03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.sut.se.g03.entity.ItemFix;

@RepositoryRestResource
public interface ItemFixRepository extends JpaRepository<ItemFix, Long>  {
    ItemFix findByItemFixId(Long itemFixId);
}
