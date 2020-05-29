
import User.*;

import java.util.Set;

public class SocialNetwork {

    private static SocialNetwork network;

    public static SocialNetwork getNetworkInstance(){
        if(network == null){
            network = new SocialNetwork();
        }
        return network;
    }

    public void createUser(String name){
        User user = new User(name);
        Set<User> users = UserList.getUserList();
        users.add(user);
    }

    public void followUser(User user1,User user2){
        user2.addFollower(user1);
    }


}
