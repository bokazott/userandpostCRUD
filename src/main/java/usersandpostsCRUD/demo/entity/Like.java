package usersandpostsCRUD.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Like(){

    }
    public Like(User user, Post post){
        this.user=user;
        this.post=post;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Post getPost() {
        return post;
    }

    public void setId(Long id){
        this.id=id;
    }
    public void setUser(User user){
        this.user=user;
    }
    public void setPost(Post post){
        this.post=post;
    }

}