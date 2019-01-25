package com.sut.se.g03.repository;

import com.sut.se.g03.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ItemRepository extends JpaRepository<Item, Long>  {
    Item findByItemId(Long itemId);
}
