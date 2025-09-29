

import task.Task;
import task.TaskList;
import ui.Ui;

public class DeleteCommand extends Command {
    private int itemNumber;

    public DeleteCommand(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, Storage storage, TaskList listOfUserTasks) throws TwinException {
        if (itemNumber < 1 || itemNumber > listOfUserTasks.size()) {
            throw new TwinException("Task number " + itemNumber + " does not exist.");
        }
        Task removedTask = listOfUserTasks.remove(itemNumber - 1);
        ui.showDeletedTask(removedTask, listOfUserTasks.size());
    }
}
