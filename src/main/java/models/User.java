package models;

public class User {

    String email;
    String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User witnEmail(String email) {
        this.email = email;
        return this;
    }

    public User witnPassword(String password) {
        this.password = password;
        return this;
    }
}
