package org.zhen.dao;

import org.zhen.exception.UserNotFoundException;
import org.zhen.exception.UserOutOfLimitException;
import org.zhen.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private int userLimit;
    private int userCount;
    private int userId;
    private List<User> userArray;

    public UserDao() {
        userCount = 0;
        userId = 0;
        userLimit = 10;
        userArray = new ArrayList<User>();
    }

    public int getUserLimit() {
        return userLimit;
    }
    public int getUserCount() {
        return userCount;
    }


    public void addUser(String userName, String password, String emailId) throws UserOutOfLimitException {
        /* Adding new user to the user array
        *
        * */
        if (userCount >= userLimit) {
            throw new UserOutOfLimitException("User is out of limit");
        }

        userCount++;
        User user = new User(userName, password, emailId, userId);
        userArray.add(user);
        userId++;
    }

    public User getUserById(int userId){
        /* Get User by User Id
         *
         */
        User user = null;
        for(User u : userArray){
            if(u.getUserId() == userId){
                user = u;
            }
        }
        return user;
    }

    public User getUserByName(String name){
        /* find user by userName

         */
        User user = null;
        for(User u : userArray){
            if(u.getUserName().equals(name)){
                user = u;
            }
        }
        return user;
    }

    public void deleteUser(int userId) throws UserNotFoundException {
        /* Delete user by userId
        * */

        User user = getUserById(userId);
        if(user == null){
            throw new UserNotFoundException("User not found");
        }
        userCount--;
        userArray.remove(user);

    }

}
