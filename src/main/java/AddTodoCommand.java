import task.TaskList;
import ui.Ui;

public class AddTodoCommand extends Command {
    private String taskDescription;

    public AddTodoCommand(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, Storage storage, TaskList listOfUserTasks) {
        Todo todo = new Todo(taskDescription);
        listOfUserTasks.add(todo);
        ui.showAddedTodo(todo);
    }
}
