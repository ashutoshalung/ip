import java.io.File;

public class Task {
    protected String description;
    protected int isDone;
    protected int taskNumber;
    protected static int numberOfTasks=0;
    protected static char symbol = 'T';

    public Task(String description) {
        this.description = description;
        this.isDone = 0;
        this.taskNumber=numberOfTasks+1;
        numberOfTasks+=1;
    }

    public void markAsDone() {
        this.isDone = 1;
    }

    public void unMark() {
        this.isDone = 0;
    }

    public String getStatusIcon() {
        return (isDone ==1 ? this.taskNumber +  ". " + "[X] " + this.description : this.taskNumber + ". " + "  " + this.description); // mark done task with X
    }

    @Override
    public String toString() {
        return ("[ ]" + this.description);
    }


    public String toFileString() {
        return this.toString();
    }
}




