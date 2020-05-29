package User;

import java.util.*;
public class User {
    private String name;
    private Set<User> followers;
    private List<Message> posts;

    public User(String name){
        this.name = name;
        this.followers = new HashSet<>();
        this.posts = new ArrayList<>();
    }
    public String getName(){
        return name;
    }

    public void CreateUser(String name){
        User user = new User(name);
    }

    public Set<User> getFollowers(){
        return followers;
    }

    public void addFollower(User follower){
        followers.add(follower);
    }

    public List<Message> getPosts(){
        return posts;
    }

    public void addPost(Message post){
        posts.add(post);
    }


}
