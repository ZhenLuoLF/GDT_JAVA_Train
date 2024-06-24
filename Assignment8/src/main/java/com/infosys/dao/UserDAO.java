package com.infosys.dao;

import java.util.ArrayList;

import com.infosys.exceptions.UserNotFoundException;
import com.infosys.pojo.User;

public class UserDAO {
    private ArrayList<User> userList = new ArrayList<User>();
    private int count = 0;
    private int id = 0;
    

    public void addUser(String name, String password, String role){
        User user = new User(id, name,password, role);
        userList.add(user);
        id++;
        count++;
    }

    public User getUserByName(String name) throws UserNotFoundException {
        User user = null;
        for(User u : userList){
            if(u.getName().equals(name)){
                user = u;
            }
        }
        if(user == null){
            throw new UserNotFoundException("User not found");
        }
        return user;
    }
    public void deleteUser(int userId) throws UserNotFoundException {
        User user = null;
        try{
            user = getUserById(userId);
        } catch (UserNotFoundException e) {
            throw e;
        }
        userList.remove(user);
    }

    public void updateUserById(int userId, String name, String password, String role) throws UserNotFoundException {
        User user = null;
        try {
            user = getUserById(userId);
        } catch (UserNotFoundException e){
            throw e;
        }
        user.setName(name);
        user.setPassword(password);
        user.setRole(role);

    }

    public User getUserById(int userId) throws UserNotFoundException {
        User user = null;
        for ( User u : userList){
            if (u.getUserId() == userId){
                user = u;
            }
        }
        if(user == null){
            throw new UserNotFoundException("User not found");
        }
        return user;
    }
    public int getUserCount(){
        return count;
    }
}
