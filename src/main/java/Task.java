public class Task {
    protected String description;
    protected boolean isDone;
    protected int taskNumber;
    protected static int numberOfTasks=0;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.taskNumber=numberOfTasks+1;
        numberOfTasks+=1;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void unMark() {
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? this.taskNumber +  ". " + "[X] " + this.description : this.taskNumber + ". " + "  " + this.description); // mark done task with X
    }

    @Override
    public String toString() {
        return ("[ ]" + this.description);
    }
}


