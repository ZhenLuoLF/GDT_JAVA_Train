package GDT_JAVA_Train.Assignment4.src.com.infosys.dao;

import java.util.ArrayList;

import GDT_JAVA_Train.Assignment4.src.com.infosys.pojo.User;

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

    public User getUserByName(String name){
        for(User u : userList){
            if(u.getName().equals(name)){
                return u;
            }
        }
        return null;
    }
    public boolean deleteUser(int userId){
        for ( User u : userList){
            if (u.getUserId() == userId){
                userList.remove(u);
                count--;
                return true;
            }
        }
        return false;
    }

    public boolean updateUserById(int userId, String name, String password, String role){
        for ( User u : userList){
            if (u.getUserId() == userId){
                u.setName(name);
                u.setPassword(password);
                u.setRole(role);
                return true;
            }
        }
        return false;
    }

    public User getUserById(int userId){
        for ( User u : userList){
            if (u.getUserId() == userId){
                return u;
            }
        }
        return null;
    }
    public int getUserCount(){
        return count;
    }
}
