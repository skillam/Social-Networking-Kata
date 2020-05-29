package TimeLine;

//import the packages
import User.Message;
import User.User;

import java.util.*;

public class TimeLine {
    private List<Message> messages;

    public List<Message> getMessages(User currentUser){
        List<Message> wall = new ArrayList<>();
        wall.addAll(currentUser.getPosts());

        for(User follower: currentUser.getFollowers()){
            wall.addAll(follower.getPosts());
        }

        wall.sort((message1,message2) ->
                message2.getMessageTime().compareTo(message1.getMessageTime())
        );

        return wall;
    }

    public void addToTimeLine(Message message){
        messages.add(message);
    }
}
