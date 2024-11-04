package usersandpostsCRUD.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import usersandpostsCRUD.demo.entity.Country;

public interface CountryRepository extends JpaRepository<Country,Long> {
    boolean existsByName(String name);
}
