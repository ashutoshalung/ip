import task.Task;
import ui.Ui;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import task.TaskList;


public class Test {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Test(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (TwinException e) {
            ui.showError(e.getMessage());
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parse(fullCommand);
                c.execute(ui, storage, tasks);
                isExit = c.isExit();
            } catch (TwinException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Test("data/twin.txt").run();
    }
}