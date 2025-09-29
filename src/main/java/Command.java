import task.TaskList;
import ui.Ui;

public abstract class Command {
    public abstract boolean isExit();
    public abstract void execute(Ui ui, Storage storage, TaskList listOfUserTasks) throws TwinException;
}
