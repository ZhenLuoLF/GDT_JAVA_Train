package GDT_JAVA_Train.Assignment4.src.com.infosys.service;

import GDT_JAVA_Train.Assignment5.src.com.infosys.dao.*;
import GDT_JAVA_Train.Assignment5.src.com.infosys.pojo.*;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
public class TaskService {
    private TaskDAO dao = new TaskDAO();


    public void add_task(){
 
        System.out.println("Please input task below:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input task title:");
        String textTitle = scanner.nextLine();
        System.out.println("Please input task text:");
        String textText = scanner.nextLine();
        System.out.println("Please input task assigened to:");
        String assignedTo = scanner.nextLine();

        dao.add_task(textTitle, textText, assignedTo);
  
    }
    public void print_list(){
        if (dao.get_taskNumber() <= 0) {
            System.out.println("No task in list.");
            return;
        }
        ArrayList<Task> task_list = dao.get_list();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input 1 if you like to print in increasing order and 2 in decreasing order:");
        int order = scanner.nextInt();
        if (order == 1){
            System.out.println( "Your tasks in increasing order: ");
            Collections.sort(task_list, (t1, t2) -> t1.get_taskTitle().compareTo(t2.get_taskTitle()));
        }else {
            System.out.println("Your tasks in decreasing order:");
            Collections.sort(task_list, (t1, t2) -> t2.get_taskTitle().compareTo(t1.get_taskTitle()));
        }
        for (Task t : task_list){
            dao.print_task(t);
        }
    }
    
    public void print_repeated(){
        ArrayList<Task> list = dao.get_list();

        int n = list.size();
        for (int i = 0; i < n - 1; i++){
            for (int j = i + 1; j < n; j++){
                Task t1 = list.get(i);
                Task t2 = list.get(j);
                if(t1.equals(t2)){
                    System.out.println("Here's the repeated task IDs: ");
                    System.out.println(t1.get_taskId() + " and " + t2.get_taskId());
                }
            }
        }
    }

    public void update_task(){
        if (dao.get_taskNumber() <= 0) {
            System.out.println("No task in list.");
            return;
        }

       print_list();

       System.out.println("Please select which one you want to update, input the id of the task:");
       Scanner scanner = new Scanner(System.in);
       int i = scanner.nextInt();
       Task t = dao.get_task_byID(i);

       String text = t.get_taskText();
       String title = t.get_taskTitle();
       String user = t.get_assignedTo();

       System.out.println("Please select which one you want to update:");
       System.out.println("1. Task Title;");
       System.out.println("2. Task Text;");
       System.out.println("3. Task Assigned User;");
       int choince = scanner.nextInt();
       scanner.nextLine();

       switch (choince) {
        case 1:
            System.out.println("Please input new title:");
            String new_title = scanner.nextLine();
            title = new_title;
            break;
        case 2:
            System.out.println("Please input new text:");
            String new_text = scanner.nextLine();
            text = new_text;
            break;
        case 3:
            System.out.println("Please input new user:");
            String new_user = scanner.nextLine();
            user = new_user;
            break;
       
        default:
            break;
       }
       dao.update_task_byID(i, title, text, user);
       System.out.println("Success!");
    }

    public void delete_task(){
        if (dao.get_taskNumber() <= 0) {
            System.out.println("No task in list.");
            return;
        }
       print_list();

       System.out.println("Please select which one you want to update, input the id of the task:");
       Scanner scanner = new Scanner(System.in);
       int i = scanner.nextInt();
       dao.delete_task_byID(i);
       System.out.println("Success!");
    }
    public void search_task(){
        if (dao.get_taskNumber() <= 0) {
            System.out.println("No task in list.");
            return;
        }
        System.out.println("Please select how you want to search:");
        System.out.println("1. search for title;");
        System.out.println("2. Search for assigned user;");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please input search content:");
        String content = scanner.nextLine();
        System.out.println("Search result:");
        if (i == 1){
            Task t = dao.search_byTitle(content);
            if (t != null) {
                dao.print_task(t);
            }
        }else{
            Task t = dao.search_byUser(content);
            if (t != null) {
                dao.print_task(t);
            }
        }
        
    }

    public void printTaskByAssignedUser(String userName){
        ArrayList<Task> list = dao.get_list();
        for (Task t : list){
            if(t.get_assignedTo().equals(userName)){
                dao.print_task(t);
            }
        }
    }
}
