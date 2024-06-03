
/**
 * Assignment3
 */

 import java.util.Collections;
 import java.util.Scanner;


 class TodoManager {

     public static void main(String[] args) {
        //  TodoManager tdm = new TodoManager();
        TaskOperator top = new TaskOperator();
 
         Scanner scanner = new Scanner(System.in);
         System.out.println("Please enter your name");
         String userName = scanner.nextLine();  
         System.out.println("Your name is: " + userName);
 
         boolean flag = true; 
         do{
             System.out.println("Hello " + userName + " what would you like to do next? Please input the number:");
             System.out.println("1. Add task to my todo list.");
             System.out.println("2. Print my list.");
             System.out.println("3. Print repeated tasks.");
             System.out.println("4. Update task.");
             System.out.println("5. Delete task.");
             System.out.println("6. Search task.");
             System.out.println("0. Close the application.");

             int action = scanner.nextInt();
             switch (action) {
                 case 1:
                     top.add_task();
                     break;
                 case 2:
                     top.print_list();
                     break;
                 case 3:
                     top.print_repeated();
                     break;
                 case 4:
                    top.update_task();
                    break;
                 case 5:
                    top.delete_task();
                    break;
                 case 6:
                    top.search_task();
                    break;
                 case 0:
                     flag = false;
                     break;
             }
 
         }while(flag);
     }
}