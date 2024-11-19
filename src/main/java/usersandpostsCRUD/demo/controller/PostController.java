package usersandpostsCRUD.demo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/cities/{cityId}")
    public Page<PostResponseBody> getPostsByCityId(
            @PathVariable Long cityId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return postService.getPostsByCityId(cityId, pageable);
    }

    @GetMapping("/countries/{countryId}")
    public Page<PostResponseBody> getPostsByCountryId(
            @PathVariable Long countryId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return postService.getPostsByCountryId(countryId, pageable);
    }

    @PostMapping
    public PostResponseBody createPost(@Valid @RequestBody PostRequestBody postRequestBody) {
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

