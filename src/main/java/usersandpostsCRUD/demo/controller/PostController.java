package usersandpostsCRUD.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usersandpostsCRUD.demo.dto.PostDto;
import usersandpostsCRUD.demo.dto.PostResponseBody;
import usersandpostsCRUD.demo.entity.Post;
import usersandpostsCRUD.demo.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostResponseBody> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping
    public PostResponseBody createPost(@RequestBody PostDto postDto) {
        return postService.createPost(postDto);
    }

    @PutMapping("/{id}")
    public PostResponseBody updatePost(@PathVariable Long id, @RequestBody PostDto postDto) {
        return postService.updatePost(id, postDto);
    }
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}

