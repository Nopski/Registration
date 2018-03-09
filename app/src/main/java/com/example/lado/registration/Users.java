package com.example.lado.registration;

/**
 * Created by lado on 9/3/18.
 */

public class Users {

    private int _id;
    private String user, password;

    public Users() {
    }

    public Users(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int get_id() {
        return _id;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
