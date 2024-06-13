package GDT_JAVA_Train.Assignment7.src.com.infosys.pojo;

public class Task {

    private int taskId;
    private String taskTitle;
    private String taskText;
    private String assignedTo;
    private boolean isCompleted;

    public Task(int id, String title, String text, String user) {
        this.taskId = id;
        this.taskTitle = title;
        this.taskText = text;
        this.assignedTo = user;
        this.isCompleted = false;
    }

    public int get_taskId(){
        return taskId;
    }

    public String get_taskTitle(){
        return taskTitle;
    }
    public String get_taskText(){
        return taskText;
    }
    public String get_assignedTo(){
        return assignedTo;
    }

    public void set_taskId(int id){
        taskId = id;
    }

    public void set_taskTitle(String title){
        taskTitle = title;
    }
    public void set_taskText(String text){
        taskText = text;
    }
    public void set_assignedTo(String assigned){
        assignedTo = assigned;
    }

    public void setIsCompleted(boolean isCompleted){
        this.isCompleted = isCompleted;
    }

    public boolean getIsCompeleted(){
        return isCompleted;
    }

    public boolean equals(Task t){
        if(taskTitle.equals(t.get_taskTitle()) && taskText.equals(t.get_taskText()) && assignedTo.equals(t.get_assignedTo())){
            return true;
        }else {
            return false;
        }
    }

}