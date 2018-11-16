package com.sokol.restServiceDemo.restServiceDemo.user;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eva", new Date()));
        users.add(new User(3, "Jack", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId() == null){
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id){
        for(User user : users){
            if (user.getId() == id){
                return user;
            }
        }

        return null;
    }

    public User deleteById(int id){
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()){
            User user = iterator.next();
            if(user.getId() == id) {
                iterator.remove();
                return user;
            }
        }

        return null;
    }


    public static void main(String[] args) {
        users.add(null);

        // check null in list
        System.out.println(users.stream().filter(e -> Objects.nonNull(e)).collect(Collectors.toList()).toString());
    }


}
