package usersandpostsCRUD.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usersandpostsCRUD.demo.dto.LikeRequestBody;
import usersandpostsCRUD.demo.dto.LikeResponseBody;
import usersandpostsCRUD.demo.service.LikeService;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikeController {
    @Autowired
    LikeService likeService;

    @PostMapping
    public ResponseEntity<String> addLike(@RequestBody LikeRequestBody likeRequestBody){
        try{
            likeService.addLike(likeRequestBody.getUserId(), likeRequestBody.getPostId());
            return ResponseEntity.ok("Like added successfully");
        }
        catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public List<LikeResponseBody> getAllLikes(){
        return likeService.getAllLikes();
    }


}
