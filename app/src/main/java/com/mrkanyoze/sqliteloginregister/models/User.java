package com.mrkanyoze.sqliteloginregister.models;

/**
 * Created by Victor Kanyoze on 9/25/2018.
 */

public class User {

    String name = "";
    String email = "";
    String password ="";

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
