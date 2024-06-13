package GDT_JAVA_Train.Assignment7.src.com.infosys.service;

import GDT_JAVA_Train.Assignment7.src.com.infosys.dao.*;
import GDT_JAVA_Train.Assignment7.src.com.infosys.exceptions.NoTaskInListException;
import GDT_JAVA_Train.Assignment7.src.com.infosys.exceptions.TaskNotFoundException;

import GDT_JAVA_Train.Assignment7.src.com.infosys.pojo.*;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
public class TaskService {
    private TaskDAO dao = new TaskDAO();

    public void assignTaskToUser(String userName){
        if (dao.getTaskNumber() <= 0){
            System.out.println("No task in the list.");
            return;
        }

        print_list();
        System.out.println("Please input the task ID that to be assigned:");
        Scanner scanner = new Scanner(System.in);
        int taskId = scanner.nextInt();
        Task task = null;
        try{
            task = dao.getTaskByID(taskId);
        } catch (Exception e){
            System.out.println("Task not found");
            assignTaskToUser(userName);
        }
        task.set_assignedTo(userName);
    }

    public void printTaskByUserAndCompletion(String userName){
        ArrayList<Task> completedList = new ArrayList<Task>();
        ArrayList<Task> unCompletedList = new ArrayList<Task>();

        ArrayList<Task> listByName = dao.getListByAssignedUser(userName);

        for(Task t : listByName){
            if (t.getIsCompeleted()) {
                completedList.add(t);
            }else{
                unCompletedList.add(t);
            }
        }
        System.out.println("What task would you like to see:");
        System.out.println("1. Completed task;");
        System.out.println("2. Uncompleted task;");

        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();
        if (action == 1) {
            for(Task t : completedList){
                dao.printTask(t);
            }
        }else{
            for(Task t : unCompletedList){
                dao.printTask(t);
            }
        }

        
    }
    public void markTaskCompleted(int taskId) throws TaskNotFoundException {
        Task task = null;
        try {
            task = dao.getTaskByID(taskId);
        } catch (TaskNotFoundException e){
            throw e;
        }
        task.setIsCompleted(true);

    }
    public void add_task(){
 
        System.out.println("Please input task below:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input task title:");
        String textTitle = scanner.nextLine();
        System.out.println("Please input task text:");
        String textText = scanner.nextLine();
        System.out.println("Please input task assigned to:");
        String assignedTo = scanner.nextLine();

        dao.add_task(textTitle, textText, assignedTo);
  
    }
    public void print_list(){
        if (dao.getTaskNumber() <= 0) {
            System.out.println("No task in list.");
            return;
        }
        ArrayList<Task> task_list = dao.getList();
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
            dao.printTask(t);
        }
    }
    
    public void print_repeated(){
        ArrayList<Task> list = dao.getList();

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

    private int printAndSelectTaskId() throws NoTaskInListException {
        if (dao.getTaskNumber() <= 0) {
            throw new NoTaskInListException("No task in list.");
        }
        print_list();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input task ID you want to operate:");
        int taskId = scanner.nextInt();
        return taskId;
    }
    public void update_task() throws NoTaskInListException, TaskNotFoundException {
        int id = 0;
        try{
            id = printAndSelectTaskId();
        } catch (NoTaskInListException e) {
            throw e;
        }
        Task task = null;
        try{
            task = dao.getTaskByID(id);
        } catch (TaskNotFoundException e){
            throw e;
        }

       String text = task.get_taskText();
       String title = task.get_taskTitle();
       String user = task.get_assignedTo();

       System.out.println("Please select which one you want to update:");
       System.out.println("1. Task Title;");
       System.out.println("2. Task Text;");
       System.out.println("3. Task Assigned User;");
       Scanner scanner = new Scanner(System.in);
       int choice = scanner.nextInt();
       scanner.nextLine();

       switch (choice) {
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
       try{
           dao.updateTaskByID(id, title, text, user);
       }catch (TaskNotFoundException e){
           throw e;
       }
       System.out.println("Success!");
    }

    public void delete_task() throws NoTaskInListException, TaskNotFoundException {
        int id = 0;
        try{
            id = printAndSelectTaskId();
        } catch (NoTaskInListException e){
            throw e;
        }
        try{
            dao.deleteTaskByID(id);
        } catch (TaskNotFoundException e){
            throw e;
        }
       System.out.println("Success!");
    }

    public void search_task(){
        if (dao.getTaskNumber() <= 0) {
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
        Task task = null;
        if (i == 1){
            try {
                task = dao.searchByTitle(content);
            } catch (Exception e){
                System.out.println("No task found with title " + content);
                search_task();
            }
        }else{
            try{
                task = dao.searchByUser(content);
            } catch (Exception e){
                System.out.println("No task found with assigned user " + content);
                search_task();
            }
        }
        dao.printTask(task);

    }

    public void printTaskByAssignedUser(String userName){

        ArrayList<Task> task_list = dao.getListByAssignedUser(userName);
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
            dao.printTask(t);
        }
    }
}
