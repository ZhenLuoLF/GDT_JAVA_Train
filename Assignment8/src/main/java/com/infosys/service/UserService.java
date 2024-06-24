package com.infosys.service;
import java.util.Scanner;

import  com.infosys.dao.UserDAO;
import  com.infosys.exceptions.*;
import  com.infosys.pojo.User;
public class UserService {
    private UserDAO uda = new UserDAO();

    public void registerClient(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input user name:");
        String name = scanner.nextLine();
        System.out.println("Please input user password:");
        String password = scanner.nextLine();
        String role = "Client";

        uda.addUser(name, password, role);
    }

    public void registerVisitor(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input user name:");
        String name = scanner.nextLine();
        System.out.println("Please input user password:");
        String password = scanner.nextLine();
        String role = "Visitor";

        uda.addUser(name, password, role);
    }


    public User userLogin() throws NoUserInListException, UserNotFoundException, WrongCredentialException {
        if(uda.getUserCount() <= 0){
            throw new NoUserInListException("No user in List;");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your name:");
        String name = scanner.nextLine();
        System.out.println("Please input your password:");
        String password = scanner.nextLine();
        User user = null;
        try {
            user = uda.getUserByName(name);
        } catch (UserNotFoundException e) {
            throw e;
        }
        if(!password.equals(user.getPassword())){
            throw new WrongCredentialException("Wrong password");
        }
        return user;
    }

    
}
