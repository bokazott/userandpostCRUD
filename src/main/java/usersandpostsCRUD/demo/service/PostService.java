package usersandpostsCRUD.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usersandpostsCRUD.demo.dto.PostRequestBody;
import usersandpostsCRUD.demo.dto.PostResponseBody;
import usersandpostsCRUD.demo.entity.Post;
import usersandpostsCRUD.demo.entity.User;
import usersandpostsCRUD.demo.exception.PostNotFoundException;
import usersandpostsCRUD.demo.exception.UserNotFoundException;
import usersandpostsCRUD.demo.repository.PostRepository;
import usersandpostsCRUD.demo.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }
//Get all posts
    public List<PostResponseBody> getAllPosts() {
        List<Post> posts= postRepository.findAll();
        return posts.stream().map(this::mapPostToPostResponse).collect(Collectors.toList())
        ;
    }
    private PostResponseBody mapPostToPostResponse(Post post){
        return new PostResponseBody(
                post.getTitle(),
                post.getDescription(),
                post.getCreatedDate(),
                post.getUpdatedDate(),
                post.getUser().getId()
        );
    }

    // Creating a post with userid
    public PostResponseBody createPost(PostRequestBody postRequestBody) {
        User user = userRepository.findById(postRequestBody.getUserId())
                .orElseThrow(() -> new UserNotFoundException(postRequestBody.getUserId()));
        Post post = new Post(postRequestBody.getTitle(), postRequestBody.getDescription(), user);
        post.setCreatedDate(LocalDateTime.now());
        post.setUpdatedDate(LocalDateTime.now());

        Post savedPost = postRepository.save(post);
        return mapPostToPostResponse(savedPost);
    }
    //Updating a post
   public PostResponseBody updatePost(Long id, PostRequestBody postRequestBody){
        Post existingPost=postRepository.findById(id)
                .orElseThrow(()-> new PostNotFoundException(postRequestBody.getUserId()));
        if(!existingPost.getUser().getId().equals(postRequestBody.getUserId())){
            throw new UserNotFoundException(postRequestBody.getUserId());
        }
        existingPost.setTitle(postRequestBody.getTitle());
        existingPost.setDescription(postRequestBody.getDescription());
        existingPost.setUser(userRepository.findById(postRequestBody.getUserId()).orElseThrow(()-> new UserNotFoundException(postRequestBody.getUserId())));
        existingPost.setUpdatedDate(LocalDateTime.now());
        Post updatePost=postRepository.save(existingPost);

        return mapPostToPostResponse(updatePost);
   }

//Deleting a post
    public void deletePost(Long id) {
        if (!postRepository.existsById(id)) {
            throw new PostNotFoundException(id);
        }
        postRepository.deleteById(id);
    }
}
