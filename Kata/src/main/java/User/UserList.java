package User;

import java.util.*;
public class UserList {

    private static Set<User> users;

    public static void printUserList(){
        final String ANSI_BLUE =  "\u001B[34m";
        System.out.println(ANSI_BLUE + "Following is the list of users:" +ANSI_BLUE);
        if(users == null){
            users = new HashSet<>();
        }
        int index = 1;
        for(User user:users){
            System.out.println(ANSI_BLUE+index + "." +user.getName()+ANSI_BLUE);
            index++;
        }
    }

    public static Set<User> getUserList(){
       if(users == null){
            users = new HashSet<>();
        }
        return users;
    }

    public static User getUser(String name){
        if(users == null){
            users = new HashSet<>();
        }
        for(User user:users){
            if(name.equalsIgnoreCase(user.getName())){
                return user;
            }
        }
        return null;
    }
}
