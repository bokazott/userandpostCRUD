package usersandpostsCRUD.demo.dto;

import usersandpostsCRUD.demo.entity.Post;
import usersandpostsCRUD.demo.entity.User;

public class LikeResponseBody {
  private Long userId;
  private Long postId;

    public LikeResponseBody() {
    }

    public LikeResponseBody(Long userId, Long postId) {
        this.userId = userId;
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
