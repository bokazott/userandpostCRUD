package usersandpostsCRUD.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import usersandpostsCRUD.demo.entity.City;
import usersandpostsCRUD.demo.entity.Country;

public interface CityRepository extends JpaRepository<City,Long> {
    boolean existsByNameAndCountry(String name, Country country);
}
