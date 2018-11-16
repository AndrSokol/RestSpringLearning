package com.sokol.restServiceDemo.restServiceDemo.post;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostDaoService {

    private static List<Post> posts = new ArrayList<>();
    private static int postsCount = 4;

    static{
        posts.add(new Post(1,1, "First Adam's post"));
        posts.add(new Post(1,2, "Second Adam's post"));
        posts.add(new Post(2,3, "First Eva's post"));
        posts.add(new Post(3,4, "First Jack's post"));
    }

    public List<Post> findAllByUserId(int userId){
        return posts.stream().filter(e -> e.getUserId() == userId).collect(Collectors.toList());
    }

    public Post savePostForUser(Post post){

        if(post.getId() == null)
            post.setId(++postsCount);

        posts.add(post);
        return post;
    }

    public List<Post> getOnePostForUser(int userId, int postId){
        return posts.stream().filter(e -> e.getUserId() == userId).filter(e -> e.getId() == postId).collect(Collectors.toList());
    }
}
