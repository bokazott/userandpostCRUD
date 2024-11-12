package usersandpostsCRUD.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import usersandpostsCRUD.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u JOIN u.city c WHERE c.id = :cityId")
    Page<User> findByCityId(@Param("cityId") Long cityId, Pageable pageable);

    @Query("SELECT u FROM User u JOIN u.city c JOIN c.country co WHERE co.id = :countryId")
    Page<User> findByCountryId(@Param("countryId") Long countryId, Pageable pageable);
}
