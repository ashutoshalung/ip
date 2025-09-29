import task.Task;
import task.TaskList;
import ui.Ui;

public class MarkCommand extends Command {
    private int itemNumber;

    public MarkCommand(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, Storage storage, TaskList listOfUserTasks) throws TwinException {
        if (itemNumber > listOfUserTasks.size() || itemNumber <= 0) {
            throw new TwinException("Please give me an item number that lies within the list!");
        }
        Task taskMarked = listOfUserTasks.get(itemNumber - 1);
        taskMarked.markAsDone();
        ui.showMarkedTask(taskMarked);
    }
}
