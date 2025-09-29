import task.Task;
import task.TaskList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    // Load tasks from file into an ArrayList<Task>
    public ArrayList<Task> load() throws TwinException {
        ArrayList<Task> listOfUserTasks = new ArrayList<>();
        File file = new File(filePath);

        try {
            if (!file.exists()) {
                if (file.getParentFile() != null) {
                    file.getParentFile().mkdirs(); // create directories if missing
                }
                file.createNewFile(); // create empty file
                return listOfUserTasks;
            }

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" \\| ");

                if (parts.length < 3) continue; // skip invalid lines

                String type = parts[0];
                int isDone = Integer.parseInt(parts[1]);
                String description = parts[2];

                switch (type) {
                case "T":
                    Todo todo = new Todo(description);
                    if (isDone == 1) todo.markAsDone();
                    listOfUserTasks.add(todo);
                    break;
                case "D":
                    if (parts.length >= 4) {
                        String by = parts[3];
                        Deadline deadline = new Deadline(description, by);
                        if (isDone == 1) deadline.markAsDone();
                        listOfUserTasks.add(deadline);
                    }
                    break;
                case "E":
                    if (parts.length >= 5) {
                        String from = parts[3];
                        String to = parts[4];
                        Event event = new Event(description, from, to);
                        if (isDone == 1) event.markAsDone();
                        listOfUserTasks.add(event);
                    }
                    break;
                default:
                    // unknown task type → skip
                    break;
                }
            }
            scanner.close();
        } catch (IOException e) {
            throw new TwinException("Error loading tasks from file: " + e.getMessage());
        }

        return listOfUserTasks;
    }

    // Save the TaskList to file
    public void writeToFile(TaskList listOfUserTasks) throws TwinException {
        try (FileWriter fw = new FileWriter(this.filePath, false)) { // overwrite
            for (Task t : listOfUserTasks.getAllTasks()) {
                fw.write(t.toFileString() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new TwinException("Error writing tasks to file: " + e.getMessage());
        }
    }
}
