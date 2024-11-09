package usersandpostsCRUD.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usersandpostsCRUD.demo.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByCityId(Long cityId);
    List<User> findByCityCountryId(Long countryId);
}
