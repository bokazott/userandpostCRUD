package usersandpostsCRUD.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import usersandpostsCRUD.demo.dto.PostRequestBody;
import usersandpostsCRUD.demo.dto.PostResponseBody;
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
    public PostResponseBody createPost(@RequestBody PostRequestBody postRequestBody) {
        return postService.createPost(postRequestBody);
    }

    @PutMapping("/{id}")
    public PostResponseBody updatePost(@PathVariable Long id, @RequestBody PostRequestBody postRequestBody) {
        return postService.updatePost(id, postRequestBody);
    }
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}

