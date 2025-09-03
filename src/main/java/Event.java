public class Event extends Task {
    protected String from;
    protected String to;

    public Event(String description, String from, String to) {
        super(description);
        this.from=from;
        this.to=to;
    }

    @Override
    public String getStatusIcon() {
        return (isDone ? this.taskNumber +  ". " + "[E]" + "[X]" + this.description + " (from: " + from + "to: " + to + ")": "[E]" + super.toString() + " (from: " + from + "to: " + to + ")");
    }

    @Override
    public String toString() {
        return "Got it. I have added this task: \n [E]" + super.toString() + " (from: " + from + " to: " + to + ")" + "\nNow you have " + Task.numberOfTasks + " tasks in the list";

    }
}

