package GDT_JAVA_Train.Assignment7.src.com.infosys.controller;

import java.util.Scanner;

import GDT_JAVA_Train.Assignment7.src.com.infosys.exceptions.UserNotFoundException;
import GDT_JAVA_Train.Assignment7.src.com.infosys.exceptions.WrongCredentialException;
import GDT_JAVA_Train.Assignment7.src.com.infosys.pojo.User;
import GDT_JAVA_Train.Assignment7.src.com.infosys.service.*;

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
               System.out.println("Hello what would you like to do next? Please input the number:");
               System.out.println("1. Add task to todo list.");
               System.out.println("2. Print list.");
               System.out.println("3. Print repeated tasks.");
               System.out.println("4. Update task.");
               System.out.println("5. Delete task.");
               System.out.println("6. Search task.");
               System.out.println("7. Register a visitor.");
               System.out.println("8. Assign task to user.");
               System.out.println("9. Log out.");
               System.out.println("0. Close the application.");

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
                  case 9:
                     user = null;
                     break;
                  case 0:
                     return;
               }
            }else if(user.getRole().equals("Visitor")){
               System.out.println("Hello what would you like to do next? Please input the number:");
               System.out.println("1. Print tasks that assigned to me.");
               System.out.println("2. Mark task as completed.");
               System.out.println("3. Print tasks by completion.");
               System.out.println("4. Log out.");
               System.out.println("0. Close the application.");
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
                  case 4:
                     user = null;
                     break;
                  case 0:
                     return;
               }
            }
 
         }
     }
}