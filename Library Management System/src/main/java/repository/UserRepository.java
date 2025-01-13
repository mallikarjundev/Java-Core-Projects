package repository;

import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {
    private static List<User> users = new ArrayList<>();

    public static void addUser(User user){
        users.add(user);
    }

    public static List<User> getUserList(){
        return users;
    }

    public static User getUser(String username){
        return users.stream().filter(user -> user.getName().equals(username)).findFirst().orElse(null);
    }
}
