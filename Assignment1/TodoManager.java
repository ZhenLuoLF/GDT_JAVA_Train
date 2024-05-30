
/**
 * Assignment1
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


class TodoManager {
    String[] task_list = new String[5];
    public static void main(String[] args) {
        TodoManager tdm = new TodoManager();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name");
        String userName = scanner.nextLine();  // Read user input
        System.out.println("Your name is: " + userName);  // Output user input

        boolean flag = true; 
        do{
            System.out.println("Hello " + userName + " what would you like to do next? Please input the number:");
            System.out.println("1. Add task to my todo list.");
            System.out.println("2. Print my list.");
            System.out.println("3. Print repeated tasks.");
            System.out.println("4. Close the application.");
            // Scanner scanner2 = new Scanner(System.in);
            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    tdm.add_task();
                    break;
                case 2:
                    tdm.print_list();
                    break;
                case 3:
                    tdm.print_repeated();
                    break;
                case 4:
                    flag = false;
                    break;
            }

        }while(flag);
    }
    void add_task(){

        System.out.println("Please input 5 task below:");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++){
            System.out.println("Please input your next task:");
            String task = scanner.nextLine();
            task_list[i] = task;
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
            Arrays.sort(task_list);
            System.out.println( "Your tasks in increasing order: ");
            for (int i = 0; i < 5; i++) {
                System.out.println(task_list[i]);
            }
        }else {
            Arrays.sort(task_list, Collections.reverseOrder());
            System.out.println("Your tasks in decreasing order:");
            for (int i = 0; i < 5; i++) {
                System.out.println(task_list[i]);
            }
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
                    System.out.println("Here's the repeated task: ");
                    System.out.println(task_list[i]);
                }
            }
        }
    }
    
}