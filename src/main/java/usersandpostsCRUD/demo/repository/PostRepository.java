package usersandpostsCRUD.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usersandpostsCRUD.demo.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}
