import User.*;
import TimeLine.*;

import java.time.temporal.ChronoUnit;
import java.util.*;
import java.time.*;

public class SocialNetworkingKata {

    public static void printWall(List<Message> posts){

        final String ANSI_PURPLE = "\u001B[35m";
        if(posts.size() == 0){
            System.out.println(ANSI_PURPLE+ "No posts to display" + ANSI_PURPLE);
            return;
        }
        for(Message post:posts){
            ZonedDateTime postTime = post.getMessageTime();
            long minutes = postTime.until(ZonedDateTime.now(), ChronoUnit.MINUTES);
            long seconds = postTime.until(ZonedDateTime.now(), ChronoUnit.SECONDS);
            if(minutes <= 0)
                System.out.println(ANSI_PURPLE + post.getUser().getName() + " - " + post.getText() + " (" + seconds + " seconds)" + ANSI_PURPLE);
            else if(minutes == 1)
                System.out.println(ANSI_PURPLE + post.getUser().getName() + " - " + post.getText() + " (" + minutes + " minute)" + ANSI_PURPLE);
            else
                System.out.println(ANSI_PURPLE + post.getUser().getName() + " - " + post.getText() + " (" + minutes + " minutes)" + ANSI_PURPLE);


        }
    }

    public static void commandLine(SocialNetwork network){
        Scanner scanner = new Scanner(System.in);
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_CYAN = "\u001B[36m";
        System.out.println(ANSI_YELLOW + "What do you want to do?" + ANSI_YELLOW);
        System.out.println("1.Create a user");
        System.out.println("2.Create a new post");
        System.out.println("3.See a user's timeline");
        System.out.println("4.Follow a user");
        System.out.println("5.List the users");
        System.out.println("6.Close the social network");
        System.out.println("Please enter the number corresponding to the request(1,2 or 3)");
        boolean close = false;
        int option = scanner.nextInt();
        String name = "";
        User currentUser = null;
        scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.print(ANSI_CYAN + "What's the new user's name?" + ANSI_CYAN);
                    String userName = scanner.nextLine();
                    network.createUser(userName);
                    break;
                case 2:
                    UserList.printUserList();
                    System.out.print(ANSI_CYAN + "Enter the user name:" + ANSI_CYAN);
                    name = scanner.nextLine();
                    currentUser = UserList.getUser(name);
                    System.out.print(ANSI_CYAN + "Enter the post for the user:" + ANSI_CYAN);
                    String text = scanner.nextLine();
                    Message post = new Message(text,ZonedDateTime.now(),currentUser);
                    currentUser.addPost(post);
                    break;
                case 3:
                    UserList.printUserList();
                    System.out.print(ANSI_CYAN + "Enter the user name:" + ANSI_CYAN);
                    name = scanner.nextLine();
                    currentUser = UserList.getUser(name);
                    TimeLine wall = new TimeLine();
                    if (currentUser != null) {
                        List<Message> posts = wall.getMessages(currentUser);
                        printWall(posts);
                    } else {
                        System.out.println(ANSI_CYAN + "There is no user with the given name" + ANSI_CYAN);
                    }
                    break;
                case 4:
                    UserList.getUserList();
                    System.out.print(ANSI_CYAN + "Who is the follower:" + ANSI_CYAN);
                    String followerName = scanner.nextLine();
                    User followerUser = UserList.getUser(followerName);
                    System.out.print(ANSI_CYAN + "Who is the followee:" + ANSI_CYAN);
                    String followeeName = scanner.nextLine();
                    User followeeUser = UserList.getUser(followeeName);
                    network.followUser(followeeUser, followerUser);
                    break;
                case 5:
                    UserList.printUserList();
                    break;
                case 6:
                    close = true;
                    break;

            }
        if(!close)
            commandLine(network);
        else
            return;
    }

    public static void main(String[] args){
        final String ANSI_YELLOW = "\u001B[33m";
        System.out.println(ANSI_YELLOW+ "Welcome to Social Networking Kata, there are no users now.Please create a user"+ANSI_YELLOW);
        SocialNetwork network = SocialNetwork.getNetworkInstance();//Singleton pattern
        System.out.print("What's the new user's name?");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        //create this user
        network.createUser(userName);
        commandLine(network);

    }
}
