package com.infosys.thread;

import com.infosys.pojo.User;
import com.infosys.service.TaskService;
import com.infosys.service.UserService;

import java.util.Scanner;

public class VisitorThread extends Thread {
    User user;
    TaskService taskService;
    UserService userService;

    public VisitorThread(User user, TaskService taskService, UserService userService) {
        this.user = user;
        this.taskService = taskService;
        this.userService = userService;
    }
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            System.out.println("Hello what would you like to do next? Please input the number:");
            System.out.println("1. Print tasks that assigned to me.");
            System.out.println("2. Mark task as completed.");
            System.out.println("3. Print tasks by completion.");
            System.out.println("0. Log out.");
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
                    taskService.printTaskByAssignedUser(user.getName());
                    break;
                case 2:
                    taskService.printTaskByAssignedUser(user.getName());
                    System.out.println("Select which task should you mark:");
                    int taskId = 0;
                    try{
                        taskId = scanner.nextInt();
                    }catch (Exception e){
                        System.out.println("Please enter a valid option!");
                        continue;
                    }finally {
                        scanner.nextLine();
                    }

                    try{
                        taskService.markTaskCompleted(taskId);
                    } catch (Exception e){
                        e.printStackTrace();
                    }

                    break;
                case 3:
                    taskService.printTaskByUserAndCompletion(user.getName());
                    break;
                case 0:
                    flag = false;
                    break;
            }
        }
    }
}
