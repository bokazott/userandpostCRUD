package usersandpostsCRUD.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import usersandpostsCRUD.demo.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    @Query("SELECT p FROM Post p JOIN p.user u JOIN u.city c WHERE c.id = :cityId")
    Page<Post> findAllByCityId(@Param("cityId") Long cityId, Pageable pageable);
    @Query("SELECT p FROM Post p JOIN p.user u JOIN u.city c JOIN c.country co WHERE co.id = :countryId")
    Page<Post> findAllByCountryId(@Param("countryId") Long countryId, Pageable pageable);
}
