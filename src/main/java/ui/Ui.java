package ui;

import java.util.ArrayList;
import java.util.Scanner;
import task.Task;
import task.TaskList;

public class Ui {
    private static final String logo =

                    "████████╗ ██╗    ██╗ ██╗ ███╗   ██╗\n" +
                    "╚══██╔══╝ ██║    ██║ ██║ ████╗  ██║\n" +
                    "   ██║    ██║ █╗ ██║ ██║ ██╔██╗ ██║\n" +
                    "   ██║    ██║███╗██║ ██║ ██║╚██╗██║\n" +
                    "   ██║    ╚███╔███╔╝ ██║ ██║ ╚████║\n" +
                    "   ╚═╝     ╚══╝╚══╝  ╚═╝ ╚═╝  ╚═══╝\n";

    private Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in); // single scanner instance
    }

    public void showWelcome() {
        printBox("Hello from\n" + logo + "Hello I am Twin\nNice to meet you!\nWhat can I do for you?");
    }

    public void showError(String error) {
        printBox(error);
    }

    public void showLine() {
        System.out.println("-------------------------------------------------------------------------------");
    }

    public String readCommand() {
        System.out.println();
        return scanner.nextLine().trim();
    }

    public void showTasks(TaskList tasks) {
        if (tasks.size() == 0) {
            printBox("Your task list is empty!");
            return;
        }
        int count = 1;
        for (Task t : tasks.getAllTasks()) {
            printBox(count + ". " + t.getStatusIcon());
            count++;
        }
    }

    public void showMarkedTask(Task taskMarked) {
        printBox("Nice! I've marked this task as done:\n" + taskMarked);
    }

    public void showUnMarkedTask(Task taskUnMarked) {
        printBox("OK, I've marked this task as not done yet:\n" + taskUnMarked);
    }

    public void showAddedDeadline(Task deadline) {
        printBox("Got it. I have added this task:\n" + deadline);
    }

    public void showAddedTodo(Task todo) {
        printBox("Got it. I have added this task:\n" + todo);
    }

    public void showAddedEvent(Task event) {
        printBox("Got it. I have added this task:\n" + event);
    }

    public void showDeletedTask(Task removedTask, int listSize) {
        printBox("Noted. I have removed this task:\n" + removedTask +
                "\nNow you have " + listSize + " tasks in the list.");
    }

    public void showGoodbye() {
        printBox("Goodbye! Hope to see you again soon!");
    }

    public static void printBox(String message) {
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println(message);
        System.out.println("--------------------------------------------------------------------------------------------");
    }
}
