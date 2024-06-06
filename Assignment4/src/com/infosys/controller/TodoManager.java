package GDT_JAVA_Train.Assignment4.src.com.infosys.controller;

import java.util.Scanner;

import GDT_JAVA_Train.Assignment4.src.com.infosys.pojo.User;
import GDT_JAVA_Train.Assignment4.src.com.infosys.service.*;

class TodoManager {
      public static void main(String[] args) {
         TaskService ts = new TaskService();
         UserService us = new UserService();

         Scanner scanner = new Scanner(System.in);

         User u = null;

         while(true){
            if(u == null){
               System.out.println("Please select function:");
               System.out.println("1. Register as a client.");
               System.out.println("2. Login.");
               System.out.println("0. Exit.");
               int action = scanner.nextInt();
               scanner.nextLine();
               switch (action) {
                  case 1:
                     us.registerClient();
                     break;
                  case 2:
                     u = us.userLogin();
                     break;
                  case 0:
                     return;
               }
            }else if (u.getRole().equals("Client")) {
               System.out.println("Hello what would you like to do next? Please input the number:");
               System.out.println("1. Add task to todo list.");
               System.out.println("2. Print list.");
               System.out.println("3. Print repeated tasks.");
               System.out.println("4. Update task.");
               System.out.println("5. Delete task.");
               System.out.println("6. Search task.");
               System.out.println("7. Register a visitor.");
               System.out.println("8. Log out.");
               System.out.println("0. Close the application.");
  
               int action = scanner.nextInt();
               switch (action) {
                  case 1:
                     ts.add_task();
                     break;
                  case 2:
                     ts.print_list();
                     break;
                  case 3:
                     ts.print_repeated();
                     break;
                  case 4:
                     ts.update_task();
                     break;
                  case 5:
                     ts.delete_task();
                     break;
                  case 6:
                     ts.search_task();
                     break;
                  case 7:
                     us.registerVisitor();
                     break;
                  case 8:
                     u = null;
                     break;
                  case 0:
                     return;
               }
            }else if(u.getRole().equals("Visitor")){
               System.out.println("Hello what would you like to do next? Please input the number:");
               System.out.println("1. Print tasks that assigned to me.");
               System.out.println("2. Log out.");
               System.out.println("0. Close the application.");
  
               int action = scanner.nextInt();
               switch (action) {
                  case 1:
                     ts.printTaskByAssignedUser(u.getName());;
                     break;
                  case 2:
                     u = null;
                     break;
                  case 0:
                     return;
               }
            }
 
         }
     }
}