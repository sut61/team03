package project.se.demo.repository;
import project.se.demo.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DistrictRepository  extends JpaRepository<District, Long> {
    District findById(long districtId);
}
