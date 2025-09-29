package task;

public class Task {
    protected String description;
    protected int isDone; // 0 = not done, 1 = done
    protected static int numberOfTasks = 0;

    protected int taskNumber;

    public Task(String description) {
        this.description = description;
        this.isDone = 0;
        numberOfTasks++;
        this.taskNumber= Task.numberOfTasks;
    }

    public void markAsDone() { this.isDone = 1; }
    public void unMarkAsDone() { this.isDone = 0; }

    public String getStatusIcon() {
        return "[" + (isDone == 1 ? "X" : " ") + "] " + description;
    }

    @Override
    public String toString() {
        return getStatusIcon();
    }

    public String toFileString() {
        return "T | " + isDone + " | " + description;
    }

    public int getTaskNumber() {
        return taskNumber;
    }


}