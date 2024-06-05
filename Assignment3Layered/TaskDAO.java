import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;
import java.util.ArrayList;

class TaskDAO {

    // Task[] task_list = new Task[5];

    private ArrayList<Task> task_list = new ArrayList<Task>();
    private int count = 0;
    private int id = 0;

    public ArrayList<Task> get_list(){
        return task_list;
    }
    public void print_task(Task task){
        System.out.println("Task ID:");
        System.out.println(task.get_taskId());
        System.out.println("Task title:");
        System.out.println(task.get_taskTitle());
        System.out.println("Task text:");
        System.out.println(task.get_taskText());
        System.out.println("Task assigned to:");
        System.out.println(task.get_assignedTo());
    }

    public Task search_byTitle(String title){
        for(Task t : task_list){
            if(t.get_taskTitle().equals(title)){
                return t;
            }
        }
        return null;
    }
    public Task search_byUser(String user){
        for(Task t : task_list){
            if(t.get_assignedTo().equals(user)){
                return t;
            }
        }
        return null;
    }
    public int get_taskNumber(){
        return count;
    }
    public void add_task(String title, String text, String user){
        Task task = new Task(id, title, text, user);
        task_list.add(task);
        count++;
        id++;
    }

    public void delete_task_byID(int id){
        for(Task t : task_list){
            if(t.get_taskId() == id){
                task_list.remove(t);
                break;
            }
        }
        count--;
    }

    public void update_task_byID(int id, String title, String text, String user){
        for(Task t : task_list){
            if(t.get_taskId() == id){

                t.set_taskTitle(title);
                t.set_taskText(text);
                t.set_assignedTo(user);
            }
        }
    }

    public Task get_task_byID(int id){
        for(Task t : task_list){
            if(t.get_taskId() == id){
                return t;
            }
        }
        return null;
    }

} 
 