import task.TaskList;
import ui.Ui;

public class ListCommand extends Command{
    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, Storage storage, TaskList listOfUserTasks) throws TwinException {
        if (listOfUserTasks.size() > 0) {
            ui.showTasks(listOfUserTasks);
        } else {
            throw new TwinException("list is empty currently!");
        }
    }
}
