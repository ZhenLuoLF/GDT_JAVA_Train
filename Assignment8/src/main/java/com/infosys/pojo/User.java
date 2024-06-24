package com.infosys.pojo;

public class User {
    private int userId;
    private String name;
    private String role;
    private String password;

    public User(int id,String name, String password, String role){
        this.userId = id;
        this.role = role;
        this.name = name;
        this.password = password;

    }

    public void setName(String name){
        this.name = name;
    }

    public void setRole(String role){
        this.role = role;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }
    public int getUserId(){
        return userId;
    }

    public String getName(){
        return name;
    }

    public String getRole(){
        return role;
    }
}
