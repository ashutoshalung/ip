import task.Task;
import ui.Ui;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import task.TaskList;

public class Twin {
    private static final String DATA_DIR = "./data";
    private static final String DATA_FILE = DATA_DIR + "/twin.txt";
    private static File filePath;

    public Twin() throws IOException {
    }

    public static void ensureDataDirExists() {
        File dir = new File(DATA_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    public static void main(String[] args) {
        filePath = new File(DATA_FILE);
        Ui ui = new Ui();
        ui.showWelcome();

        ensureDataDirExists();

        String userText = ui.readCommand();
        Storage storage = new Storage(DATA_FILE);
        TaskList listOfUserTasks = new TaskList();
        ArrayList<Task> tasks = listOfUserTasks.getAllTasks();
        try {
            tasks = storage.load();
        } catch (TwinException e) {
            throw new RuntimeException(e);
        }
//        ArrayList<Task> listOfUserTasks = new ArrayList<>();


        while (!userText.equalsIgnoreCase("bye")) {

            String[] inputParts = null;
            String command = null;
            try {
                inputParts = userText.split(" ");
                if (inputParts.length >= 1) {

                    command = inputParts[0].toLowerCase();
                } else {
                    throw new TwinException("Please enter a valid input!");
                }
            } catch (TwinException d) {
                Ui.printBox(d.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                Ui.printBox("Again, please enter a valid input!");
            }


            try {
                switch (command) {
                case "list":
                    for (Task t : tasks) {
                        Ui.printBox(t.getTaskNumber() + " " + t.getStatusIcon());
                    }
                    break;
                case "mark":

                    int itemNumber = 0;
                    try {
                        if (inputParts.length > 1) {
                            itemNumber = Integer.parseInt(inputParts[1]);
                            Task taskMarked = listOfUserTasks.get(itemNumber - 1);
                            taskMarked.markAsDone();
                            Ui.printBox("Nice I have marked item number " + itemNumber + "\n" + taskMarked.getTaskNumber()
                                    + " " + taskMarked.getStatusIcon());
                            break;
                        } else {
                            throw new TwinException("Please add what item number to mark.");
                        }
                    } catch (TwinException e) {
                        Ui.printBox(e.getMessage());
                    } catch (NumberFormatException e) {
                        Ui.printBox("Please give a valid number to mark.");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        Ui.printBox("Please give me an item number that lies within the list!");
                    } catch (NullPointerException e) {
                        Ui.printBox("Please give me a valid number to mark!");
                    }

                case "unmark":

                    try {
                        if (inputParts.length > 1) {
                            itemNumber = Integer.parseInt(inputParts[1]);
                            Task taskUnmarked = listOfUserTasks.get(itemNumber - 1);
                            taskUnmarked.unMarkAsDone();
                            Ui.printBox("Nice I have marked item number " + itemNumber + "\n" + taskUnmarked.getTaskNumber() + " " + taskUnmarked.getStatusIcon());
                        } else {
                            throw new TwinException("Please add what item number to mark.");
                        }


                    } catch (NumberFormatException e) {
                        throw new RuntimeException(e);
                    } catch (TwinException e) {
                        Ui.printBox(e.getMessage());
                    }

                    break;


                case "deadline":
                    String[] deadlineParts = userText.split(" by ");
                    String taskDescription = deadlineParts[0].trim().substring("deadline".length());
                    String by = deadlineParts[1];
                    Deadline deadline = new Deadline(taskDescription, by);
                    listOfUserTasks.add(deadline);
                    Ui.printBox("Got it. I have added this event. " + "\n" + deadline);

                    break;

                case "todo":

                    taskDescription = userText.substring("todo".length());
                    Todo todo = new Todo(taskDescription);
                    listOfUserTasks.add(todo);
                    Ui.printBox("Got it. I have added this event. " + "\n" + todo);
                    System.out.println();

                    break;

                case "event":
                    // join everything after "event" into a single string

                    String[] eventParts = userText.split(" from ");
                    taskDescription = eventParts[0].trim().substring(5);
                    String[] eventTimes = eventParts[1].split(" to ");
                    String from = eventTimes[0];
                    String to = eventTimes[1];
                    Event event = new Event(taskDescription, from, to);
                    listOfUserTasks.add(event);
                    Ui.printBox("Got it. I have added this event. " + "\n" + event);
                    break;

                case "delete":
                    int itemNumberToBeDeleted = Integer.parseInt(inputParts[1]);
                    Ui.printBox("Noted I will delete this task: " + listOfUserTasks.get(itemNumberToBeDeleted - 1));
                    listOfUserTasks.remove(itemNumberToBeDeleted-1);
                    Ui.printBox("Now you have " + tasks.toArray().length + " tasks.");
                    break;


                default:
                    Ui.printBox("Not allowed. Please enter an input of the correct form");
                    break;

                }

            } catch (ArrayIndexOutOfBoundsException e) {
                Ui.printBox("Task cannot be blank!");
            } finally {
                userText = ui.readCommand();
            }
        }
        try {storage.writeToFile(listOfUserTasks);}
        catch (TwinException e) {
            Ui.printBox(e.getMessage());

        }


    }
    }
