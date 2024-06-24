package com.infosys.thread;

import com.infosys.pojo.User;
import com.infosys.service.TaskService;
import com.infosys.service.UserService;

import java.util.Scanner;

public class ClientThread extends Thread{
    User user;
    TaskService taskService;
    UserService userService;

    public ClientThread(User user, TaskService taskService, UserService userService) {
        this.user = user;
        this.taskService = taskService;
        this.userService = userService;
    }

    @Override
    public void run(){
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            System.out.println(flag);
            System.out.println("Hello what would you like to do next? Please input the number:");
            System.out.println("1. Add task to todo list.");
            System.out.println("2. Print list.");
            System.out.println("3. Print repeated tasks.");
            System.out.println("4. Update task.");
            System.out.println("5. Delete task.");
            System.out.println("6. Search task.");
            System.out.println("7. Register a visitor.");
            System.out.println("8. Assign task to user.");
            System.out.println("0. Log out");

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
                    taskService.add_task();
                    break;
                case 2:
                    taskService.print_list();
                    break;
                case 3:
                    taskService.print_repeated();
                    break;
                case 4:
                    try{
                        taskService.update_task();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    try{
                        taskService.delete_task();
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    taskService.search_task();
                    break;
                case 7:
                    userService.registerVisitor();
                    break;
                case 8:
                    scanner.nextLine();
                    System.out.println("Please input the user name you want to assigned:");
                    String userName = scanner.nextLine();
                    taskService.assignTaskToUser(userName);
                    break;
                case 0:
                    flag = false;
                    break;
            }
        }
    }
}
