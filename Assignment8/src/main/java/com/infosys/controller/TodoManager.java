package com.infosys.controller;

import java.util.Scanner;

import com.infosys.exceptions.UserNotFoundException;
import com.infosys.exceptions.WrongCredentialException;
import com.infosys.pojo.User;
import com.infosys.service.*;
import com.infosys.thread.ClientThread;
import com.infosys.thread.VisitorThread;

class TodoManager {
      public static void main(String[] args) {
         TaskService taskService = new TaskService();
         UserService userService = new UserService();

         Scanner scanner = new Scanner(System.in);

         User user = null;

         while(true){
            if(user == null){
               System.out.println("Please select function:");
               System.out.println("1. Register as a client.");
               System.out.println("2. Login.");
               System.out.println("0. Exit.");
               int action = 0;
               try{
                  action = scanner.nextInt();
               }catch (Exception e){
                  System.out.println("Please enter a valid option!");
                  continue;
               }finally {
                  scanner.nextLine();
               }

               switch (action) {
                  case 1:
                     userService.registerClient();
                     break;
                  case 2:
                     try{
                        user = userService.userLogin();
                     } catch (WrongCredentialException e){
                        System.out.println("Wrong Password");
                     }catch (UserNotFoundException e){
                        System.out.println("User not found");
                     } catch (Exception e){
                        e.printStackTrace();
                     }
                     break;
                  case 0:
                     return;
               }
            }else if (user.getRole().equals("Client")) {
               Thread thread = new ClientThread(user, taskService, userService);
               thread.start();
               try{
                  thread.join();
               }catch (Exception e){
                  e.printStackTrace();
               }
               user = null;

            }else if(user.getRole().equals("Visitor")){
               Thread thread = new VisitorThread(user, taskService, userService);
               thread.start();
               try{
                  thread.join();
               }catch (Exception e){
                  e.printStackTrace();
               }
               user = null;
            }
 
         }
     }
}