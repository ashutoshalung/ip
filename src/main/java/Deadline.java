public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String getStatusIcon() {
        return (isDone==1 ? this.taskNumber +  ". " + "[D]" + "[X]" + this.description : "[D]" + super.toString() + " (by: " + by + ")");
    }

    @Override
    public String toString() {
        return "Got it. I have added this task: \n [D]" + super.toString() + " (by: " + by + ")" + "\nNow you have " + Task.numberOfTasks + " tasks in the list";
    }

    @Override
    public String toFileString() {
        return (Deadline.symbol+" | "+this.isDone+" | "+this.description+" | "+this.by);
    }
}
