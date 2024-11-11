package usersandpostsCRUD.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import usersandpostsCRUD.demo.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.city.id=:cityId")
    List<User> findByCityId(@Param("cityId") Long cityId);
    @Query("SELECT u FROM User u WHERE u.city.country.id = :countryId")
    List<User> findByCountryId(@Param("countryId") Long countryId);
}
