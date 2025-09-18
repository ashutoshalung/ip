public class Event extends Task {
    protected String from;
    protected String to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String getStatusIcon() {
        return "[E]" + super.getStatusIcon() + " (from: " + from + " to: " + to + ")";
    }

    @Override
    public String toFileString() {
        return "E | " + isDone + " | " + description + " | " + from + " | " + to;
    }

    @Override
    public String toString() {
        return "Got it. I've added this task:\n [E]" + super.getStatusIcon() + " (from: " + from + " to: " + to + ")";
    }
}