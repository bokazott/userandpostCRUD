package usersandpostsCRUD.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import usersandpostsCRUD.demo.entity.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
