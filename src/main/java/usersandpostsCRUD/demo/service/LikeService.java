package usersandpostsCRUD.demo.service;

import org.springframework.stereotype.Service;
import usersandpostsCRUD.demo.dto.LikeResponseBody;
import usersandpostsCRUD.demo.entity.Like;
import usersandpostsCRUD.demo.entity.Post;
import usersandpostsCRUD.demo.entity.User;
import usersandpostsCRUD.demo.repository.LikeRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserService userService;
    private final PostService postService;

    public LikeService(LikeRepository likeRepository, UserService userService, PostService postService) {
        this.likeRepository = likeRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public void addLike(Long userId, Long postId) {
        User user = userService.findUserById(userId);
        Post post = postService.findPostById(postId);

        Like like = new Like(user, post);
        likeRepository.save(like);
    }

    public List<LikeResponseBody> getAllLikes() {
        return likeRepository.findAll().stream().map(this::mapToResponseBody).collect(Collectors.toList());
    }

    public LikeResponseBody mapToResponseBody(Like like){
        return new LikeResponseBody(like.getUser().getId(),like.getPost().getId());
    }
}



