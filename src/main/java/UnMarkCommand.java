import task.Task;
import task.TaskList;
import ui.Ui;

public class UnMarkCommand extends Command {
    private int itemNumber;

    public UnMarkCommand(int itemNumber) {
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
        Task taskUnMarked = listOfUserTasks.get(itemNumber - 1);
        taskUnMarked.unMarkAsDone();
        ui.showUnMarkedTask(taskUnMarked);
    }
}
