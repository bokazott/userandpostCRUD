package usersandpostsCRUD.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import usersandpostsCRUD.demo.dto.PostRequestBody;
import usersandpostsCRUD.demo.dto.PostResponseBody;
import usersandpostsCRUD.demo.entity.Post;
import usersandpostsCRUD.demo.entity.User;
import usersandpostsCRUD.demo.exception.PostNotFoundException;
import usersandpostsCRUD.demo.exception.UserNotFoundException;
import usersandpostsCRUD.demo.repository.PostRepository;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;


    @Autowired
    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService=userService;
    }
//Get all posts
    public List<PostResponseBody> getAllPosts() {
        List<Post> posts= postRepository.findAll();
        return posts.stream().map(this::mapPostToPostResponse).collect(Collectors.toList())
        ;
    }
    public Page<PostResponseBody> getPostsByCityId(Long cityId, Pageable pageable) {
        return postRepository.findAllByCityId(cityId, pageable)
                .map(this::mapPostToPostResponse);
    }

    public Page<PostResponseBody> getPostsByCountryId(Long countryId, Pageable pageable) {
        return postRepository.findAllByCountryId(countryId, pageable)
                .map(this::mapPostToPostResponse);
    }
    public Post findPostById(Long postId){
        return postRepository.findById(postId)
                .orElseThrow(()->new PostNotFoundException(postId));
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
        User user = userService.findUserById(postRequestBody.getUserId());
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
        if(postRequestBody.getTitle()!=null && !postRequestBody.getTitle().isEmpty()
        && !existingPost.getTitle().equals(postRequestBody.getTitle())){
            existingPost.setTitle(postRequestBody.getTitle());
        }
        if(postRequestBody.getDescription()!=null && !postRequestBody.getDescription().isEmpty()
                && !existingPost.getDescription().equals(postRequestBody.getDescription())){
            existingPost.setDescription(postRequestBody.getDescription());
        }
        if(postRequestBody.getUserId()!=null&& !existingPost.getUser().getId().equals(postRequestBody.getUserId())){
            User user=userService.findUserById(postRequestBody.getUserId());
            existingPost.setUser(user);
        }
        existingPost.setUpdatedDate(LocalDateTime.now());
        return mapPostToPostResponse(postRepository.save(existingPost));
   }

//Deleting a post
    public void deletePost(Long id) {
        if (!postRepository.existsById(id)) {
            throw new PostNotFoundException(id);
        }
        postRepository.deleteById(id);
    }
}
