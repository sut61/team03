package com.sut.se.g03.repository;
import com.sut.se.g03.entity.Customer;
import com.sut.se.g03.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ShopRepository extends JpaRepository <Shop, Long> {
    Shop findByShopId(long shopId);
    Shop findByCustomerShop(Customer customerShop);
}
