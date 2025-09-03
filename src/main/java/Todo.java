public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    @Override
    public String getStatusIcon() {
        return (isDone ? this.taskNumber +  ". " + "[T]" + "[X]" + this.description : "[T]" + super.toString());
    }

    @Override
    public String toString() {
        return "Got it. I have added this task: \n [T]" + super.toString() + "\nNow you have " + Task.numberOfTasks + " tasks in the list";
    }
}
