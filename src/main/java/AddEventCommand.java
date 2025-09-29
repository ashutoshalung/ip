import task.TaskList;
import ui.Ui;

public class AddEventCommand extends Command {
    private String taskDescription;
    private String from;
    private String to;

    public AddEventCommand(String taskDescription, String from, String to) {
        this.taskDescription = taskDescription;
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, Storage storage, TaskList listOfUserTasks) {
        Event event = new Event(taskDescription, from, to);
        listOfUserTasks.add(event);
        ui.showAddedEvent(event);
    }
}

