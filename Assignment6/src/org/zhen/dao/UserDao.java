package org.zhen.dao;

import org.zhen.pojo.User;

public class UserDao {
    private int userLimit;
    private int userCount;
    private int userId;
    private User[] userArray;

    public UserDao() {
        userCount = 0;
        userId = 0;
        userLimit = 10;
        userArray = new User[0];
    }

    public int getUserLimit() {
        return userLimit;
    }
    public int getUserCount() {
        return userCount;
    }


    public void addUser(String userName, String password, String emailId){
        /* Adding new user to the user array
        *
        * */

        userCount++;

        // Creating a new array that is one more large than origin one
        User[] newUserArray = new User[userCount];

        // Copy the origin array
        User user = new User(userName, password, emailId, userId);
        System.arraycopy(userArray,0,newUserArray,0,userArray.length);
        newUserArray[userArray.length] = user;


        userArray = newUserArray;
        userId++;
    }

    public User getUserById(int userId){
        /* Get User by User Id
         *
         */
        for(User user : userArray){
            if(user.getUserId() == userId){
                return user;
            }
        }
        return null;
    }

    public User getUserByName(String name){
        /* find user by userName

         */
        for(User user : userArray){
            if(user.getUserName().equals(name)){
                return user;
            }
        }
        return null;
    }

    public boolean deleteUser(int userId) {
        /* Delete user by userId
        * */
        boolean flag = false;
        // To find if this user exist
        if(getUserById(userId) != null){
            flag = true;
        }
        if (flag) {
            // User exist, delete and build the new user array
            userCount--;
            User[] newUserArray = new User[userCount];
            // Copy User from the original array to the new array, skipping the user at the specified id
            for (int i = 0, j = 0; i < userArray.length; i++) {
                if (userArray[i].getUserId() != userId) {
                    newUserArray[j++] = userArray[i];
                }
            }
            userArray = newUserArray;
            return true;
        }else{
            // User doesn't exist, return false
            return false;
        }
    }

}
