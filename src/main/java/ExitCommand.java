
import task.TaskList;
import ui.Ui;

public class ExitCommand extends Command {

    @Override
    public boolean isExit() {
        return true;
    }

    @Override
    public void execute(Ui ui, Storage storage, TaskList listOfUserTasks) throws TwinException {
        ui.showGoodbye();
        // could also trigger saving before exit
        storage.writeToFile(listOfUserTasks);

    }
}

