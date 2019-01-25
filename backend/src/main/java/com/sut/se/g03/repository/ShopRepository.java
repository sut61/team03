package project.se.demo.repository;
import project.se.demo.entity.Customer;
import project.se.demo.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ShopRepository extends JpaRepository <Shop, Long> {
    Shop findByShopId(long shopId);
    Shop findByCustomerShop(Customer customerShop);
}
