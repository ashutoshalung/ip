import task.TaskList;
import ui.Ui;

public class AddDeadlineCommand extends Command{
    private String taskDescription;
    private String by;
    public AddDeadlineCommand(String taskDescription, String by) {
        this.taskDescription=taskDescription;
        this.by=by;

    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, Storage storage, TaskList listOfUserTasks) {
        Deadline deadline = new Deadline(taskDescription, by);
        listOfUserTasks.add(deadline);
        ui.showAddedDeadline(deadline);

    }
}
