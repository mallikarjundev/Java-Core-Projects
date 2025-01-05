package repository;

import model.User;

import java.util.HashMap;
import java.util.Map;

public class DatabaseManager {

    private static DatabaseManager instance;
    private Map<String, User> userStore;

    private DatabaseManager(){
        userStore = new HashMap<>();
        userStore.put("admin",new User("admin","admin","admin@gmail.com"));
    }

    public static synchronized DatabaseManager getInstance(){
        if (instance==null){
            instance = new DatabaseManager();
        }
        return instance;
    }

    public void save(User addUser){
        userStore.put(addUser.getName(), addUser);
    }

    public boolean fetch(String name){
        User user = userStore.get(name);
        if(user!= null){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean fetch(String name, String password){
        User user = userStore.get(name);
        if(user!= null && user.getPassword().equals(password)){
            return true;
        }
        else {
            return false;
        }
    }
}
