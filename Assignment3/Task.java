class Task {

    int taskId;
    String taskTitle;
    String taskText;
    String assignedTo;

    boolean equals(Task t){
        if(taskTitle.equals(t.taskTitle) && taskText.equals(t.taskText) && assignedTo.equals(t.assignedTo)){
            return true;
        }else {
            return false;
        }
    }

    public Task(int id, String title, String text, String user) {
        this.taskId = id;
        this.taskTitle = title;
        this.taskText = text;
        this.assignedTo = user;
    }
}