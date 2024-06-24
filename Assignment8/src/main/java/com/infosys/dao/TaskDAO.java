package com.infosys.dao;

import java.util.ArrayList;

import  com.infosys.exceptions.TaskNotFoundException;
import  com.infosys.pojo.*;

public class TaskDAO {

    // Task[] task_list = new Task[5];

    private ArrayList<Task> task_list = new ArrayList<Task>();
    private int count = 0;
    private int id = 0;

    public ArrayList<Task> getList(){
        return task_list;
    }
    public ArrayList<Task> getListByAssignedUser(String userName){
        ArrayList <Task> list = new ArrayList<Task>();
        for (Task t : task_list){
            if(t.get_assignedTo().equals(userName)){
                list.add(t);
            }
        }
        return list;

    }

    public void printTask(Task task){
        System.out.println("Task ID:");
        System.out.println(task.get_taskId());
        System.out.println("Task title:");
        System.out.println(task.get_taskTitle());
        System.out.println("Task text:");
        System.out.println(task.get_taskText());
        System.out.println("Task assigned to:");
        System.out.println(task.get_assignedTo());
        System.out.println("Is completed?");
        System.out.println(task.getIsCompeleted());
    }

    public Task searchByTitle(String title) throws TaskNotFoundException {
        Task task = null;
        for(Task t : task_list){
            if(t.get_taskTitle().equals(title)){
                task = t;
            }
        }
        if(task == null){
            throw new TaskNotFoundException("Task not found");
        }
        return task;
    }
    public Task searchByUser(String user) throws TaskNotFoundException {
        Task task = null;
        for(Task t : task_list){
            if(t.get_assignedTo().equals(user)){
                task = t;
            }
        }
        if(task == null){
            throw new TaskNotFoundException("Task not found");
        }
        return task;
    }
    public int getTaskNumber(){
        return count;
    }
    public void add_task(String title, String text, String user){
        Task task = new Task(id, title, text, user);
        task_list.add(task);
        count++;
        id++;
    }

    public void deleteTaskByID(int id) throws TaskNotFoundException {
        Task task = null;
        try {
            task = getTaskByID(id);
        }catch (TaskNotFoundException e){
            throw new TaskNotFoundException("Task not found");
        }
        task_list.remove(id);
        count--;
    }

    public void updateTaskByID(int id, String title, String text, String user) throws TaskNotFoundException {
        Task task = null;
        try {
            task = getTaskByID(id);
        } catch (TaskNotFoundException e){
            throw new TaskNotFoundException("Task not found");
        }
        task.set_taskTitle(title);
        task.set_taskText(text);
        task.set_assignedTo(user);
    }

    public Task getTaskByID(int id) throws TaskNotFoundException {
        Task task = null;
        for(Task t : task_list){
            if(t.get_taskId() == id){
                task = t;
            }
        }
        if(task == null){
            throw new TaskNotFoundException("Task not found");
        }
        return task;
    }

} 
 