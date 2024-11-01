package usersandpostsCRUD.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import usersandpostsCRUD.demo.entity.City;

public interface CityRepository extends JpaRepository<City,Long> {
}
