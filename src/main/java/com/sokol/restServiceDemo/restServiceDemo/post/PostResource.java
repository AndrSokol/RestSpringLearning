package com.sokol.restServiceDemo.restServiceDemo.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PostResource {

    @Autowired
    PostDaoService service;

    @GetMapping("/users/{userId}/posts")
    public List<Post> retrieveAllPostsByUserId(@PathVariable int userId){
        return service.findAllByUserId(userId);
    }

    @GetMapping("/users/{userId}/posts/{postId}")
    public Post retrievePostById(@PathVariable int userId, @PathVariable int postId){
        List<Post> foundPosts = service.getOnePostForUser(userId, postId);
        Post post = null;

        if(foundPosts.size() == 1){
            post = foundPosts.get(0);
        } else if (foundPosts.size() == 0){
            throw new PostNotFoundException("Post with id " + postId + " and for user " + userId + " not found");
        }
        return post;
    }

    @PostMapping("/users/{userId}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable int userId, @RequestBody Post post){
        Post savedPost = service.savePostForUser(new Post(userId, post.getId(), post.getText()));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
