public class Deadline extends Task {
    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String getStatusIcon() {
        return "[D]" + super.getStatusIcon() + " (by: " + by + ")";
    }

    @Override
    public String toFileString() {
        return "D | " + isDone + " | " + description + " | " + by;
    }

    @Override
    public String toString() {
        return "Got it. I've added this task:\n [D]" + super.getStatusIcon() + " (by: " + by + ")";
    }
}