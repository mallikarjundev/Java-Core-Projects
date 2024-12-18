package model;

import repository.DatabaseManager;

public class User {
    private String username, password, email;

    public User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
