package com.example.bie_daalt.Model;

public class Users {
    private String name,phone,password;

    public Users(){

    }

    public Users(String password,String phone, String name) {
        this.password = password;
        this.phone = phone;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
