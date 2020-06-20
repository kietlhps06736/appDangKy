package com.example.appdangky.Modal;

import java.io.Serializable;

public class account implements Serializable {
    String user;
    String pass;

    public account(){

    }
    public account(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
