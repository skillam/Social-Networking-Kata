package User;
import java.time.*;
public class Message {

    private String text;
    private ZonedDateTime messageTime;
    private User user;

    public Message(String text,ZonedDateTime messageTime, User user){
        this.text = text;
        this.messageTime = messageTime;
        this.user = user;
    }

    public String getText(){
        return text;
    }

    public ZonedDateTime getMessageTime(){
        return messageTime;
    }

    public User getUser(){
        return user;
    }

}
