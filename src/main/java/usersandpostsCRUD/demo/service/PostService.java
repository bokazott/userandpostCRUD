package usersandpostsCRUD.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usersandpostsCRUD.demo.dto.PostDto;
import usersandpostsCRUD.demo.dto.PostResponseBody;
import usersandpostsCRUD.demo.dto.UserDto;
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
        UserDto userDto=new UserDto(post.getUser().getId(),
                post.getUser().getFirstName(),
                post.getUser().getLastName(),
                post.getUser().getAge(),
                post.getUser().getWeight(),
                post.getUser().getHeight(),
                post.getUser().getEmail(),
                post.getUser().getPhoneNumber());
        return new PostResponseBody(
                post.getTitle(),
                post.getDescription(),
                post.getCreatedDate(),
                post.getUpdatedDate(),
                userDto
        );
    }

    // Creating a post with userid
    public PostResponseBody createPost(PostDto postDto) {
        User user = userRepository.findById(postDto.getUserId())
                .orElseThrow(() -> new UserNotFoundException(postDto.getUserId()));
        Post post = new Post(postDto.getTitle(), postDto.getDescription(), user);
        post.setCreatedDate(LocalDateTime.now());
        post.setUpdatedDate(LocalDateTime.now());

        Post savedPost = postRepository.save(post);
        return mapPostToPostResponse(savedPost);
    }
    //Updating a post
   public PostResponseBody updatePost(Long id,PostDto postDto){
        Post existingPost=postRepository.findById(id)
                .orElseThrow(()-> new PostNotFoundException(postDto.getUserId()));
        existingPost.setTitle(postDto.getTitle());
        existingPost.setDescription(postDto.getDescription());
        existingPost.setUser(userRepository.findById(postDto.getUserId()).orElseThrow(()-> new UserNotFoundException(postDto.getUserId())));

        existingPost.update();
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
