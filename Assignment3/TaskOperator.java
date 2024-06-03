import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;
class TaskOperator {

    Task[] task_list = new Task[5];

    void print_task(Task task){
        System.out.println("Task title:");
        System.out.println(task.taskTitle);
        System.out.println("Task text:");
        System.out.println(task.taskText);
        System.out.println("Task assigned to:");
        System.out.println(task.assignedTo);
    }

    void add_task(){
 
        System.out.println("Please input 5 task below:");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++){
            int id = i;
            System.out.println("Please input task title:");
            String textTitle = scanner.nextLine();
            System.out.println("Please input task text:");
            String textText = scanner.nextLine();
            System.out.println("Please input task assigened to:");
            String assignedTo = scanner.nextLine();

            Task n_t = new Task(id, textTitle, textText, assignedTo);
            task_list[i] = n_t;
        }
  
    }
    void print_list(){
        if (task_list[0] == null) {
            System.out.println("Please input tasks first.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input 1 if you like to print in increasing order and 2 in decreasing order:");
        int order = scanner.nextInt();
        if (order == 1){
            Arrays.sort(this.task_list, new Comparator<Task>() {
                @Override
                public int compare(Task t1, Task t2) {
                    return t1.taskTitle.compareTo(t2.taskTitle);
                }
            });

            System.out.println( "Your tasks in increasing order: ");

        }else {
            Arrays.sort(this.task_list, new Comparator<Task>() {
                @Override
                public int compare(Task t1, Task t2) {
                    return t2.taskTitle.compareTo(t1.taskTitle);
                }
            });
            System.out.println("Your tasks in decreasing order:");
        }
        for (int i = 0; i < 5; i++) {
            if(task_list[i].taskId == 999){
                continue;
            }
            System.out.println(i+":");
            print_task(task_list[i]);
        }
    }
    
    void print_repeated(){
        if (task_list[0] == null) {
            System.out.println("Please input tasks first.");
            return;
        }
        for (int i = 0; i < 4; i++){
            for (int j = i + 1; j < 5; j++){
                if(task_list[i].equals(task_list[j])){
                    System.out.println("Here's the repeated task IDs: ");
                    System.out.println(task_list[i].taskId + " and " + task_list[j].taskId);
                }
            }
        }
    }

    void update_task(){
       if (task_list[0] == null) {
           System.out.println("Please input tasks first.");
           return;
       }

       this.print_list();

       System.out.println("Please select which one you want to update, input the number of the task:");
       Scanner scanner = new Scanner(System.in);
       int i = scanner.nextInt();
       System.out.println("Please select which one you want to update:");
       System.out.println("1. Task Title;");
       System.out.println("2. Task Text;");
       System.out.println("3. Task Assigned User;");
       int choince = scanner.nextInt();
       scanner.nextLine();

       switch (choince) {
        case 1:
            System.out.println("Please input new title:");
            String title = scanner.nextLine();
            task_list[i].taskTitle = title;
            break;
        case 2:
            System.out.println("Please input new text:");
            String text = scanner.nextLine();
            task_list[i].taskText = text;
            break;
        case 3:
            System.out.println("Please input new user:");
            String user = scanner.nextLine();
            task_list[i].assignedTo = user;
            break;
       
        default:
            break;
       }
       System.out.println("Success!");
    }
    void delete_task(){
       if (task_list[0] == null) {
           System.out.println("Please input tasks first.");
           return;
       }
       print_list();

       System.out.println("Please select which one you want to update, input the number of the task:");
       Scanner scanner = new Scanner(System.in);
       int i = scanner.nextInt();


       task_list[i] = new Task(999, " ", " ", " ");
       System.out.println("Success!");
    }
    void search_task(){
        if (task_list[0] == null) {
            System.out.println("Please input tasks first.");
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
            for (Task task : task_list){
                if(task.taskTitle.equals(content)){
                    print_task(task);
                }
            }
        }else{
            for (Task task : task_list){
                if(task.assignedTo.equals(content)){
                    print_task(task);
                }
            }
        }
        
    }

} 
 