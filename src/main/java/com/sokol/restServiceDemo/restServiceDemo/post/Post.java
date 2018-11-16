package com.sokol.restServiceDemo.restServiceDemo.post;

public class Post {
    private Integer userId;
    private Integer id;
    private String text;



    public Post() {
    }

    public Post(Integer userId, Integer id, String text) {
        this.userId = userId;
        this.id = id;
        this.text = text;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
