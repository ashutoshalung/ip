import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;


public class Twin {
    public static void writeToFile(String filepath, String textToAdd) {
        try {
            FileWriter fw = new FileWriter(filepath);
            fw.write(textToAdd);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        File f = new File("data/twin.txt");
        Scanner s;
        try {
            s = new Scanner(f);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Task> listOfUserTasks = new ArrayList<>();
        while (s.hasNext()) {
            String line = s.nextLine();
            String[] parts = line.split("//| "); // split by " | "
            String type = parts[0];
            String isDone = parts[1];
            String description = parts[2];

            Task task = null;
            switch (type) {
            case "T":
                task = new Todo(description);
                break;
            case "D":
                String by = parts[3];
                task = new Deadline(description, by);
                break;
            case "E":
                String from = parts[3];
                String to = parts[4];
                task = new Event(description, from, to);
                break;
            }
            if (isDone.equals("1")) {
                task.markAsDone();
            }

            listOfUserTasks.add(task);
        }

        String logo = " ____        _        \n" + "|  _ \\ _   _| | _____ \n" + "| | | | | | | |/ / _ \\\n" + "| |_| | |_| |   <  __/\n" + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello I am Twin\nNice to meet you\nWhat can I do for you?");
        Scanner input = new Scanner(System.in); //one time only, create the scanner input. 
        System.out.println();
        String userText = input.nextLine();



        while (!userText.equalsIgnoreCase("bye")) {
            String[] inputParts = userText.split(" ");
            String command = inputParts[0].toLowerCase();
            try {
                if (inputParts.length == 1 && !command.equals("list")) { //handle blah and incorrect one word statements
                    throw new DukeException("I am sorry I do not understand that.");

                }
                switch (command) {
                case "list":
                    for (Task t : listOfUserTasks) {
                        System.out.println(t.getStatusIcon());
                    }
                    break;
                case "mark":
                    int itemNumber = Integer.parseInt(inputParts[1]);
                    Task taskMarked = listOfUserTasks.get(itemNumber - 1);
                    taskMarked.markAsDone();
                    System.out.println("Nice I have marked item number " + itemNumber + "\n" + taskMarked.getStatusIcon());
                    break;

                case "unmark":

                    itemNumber = Integer.parseInt(inputParts[1]);
                    Task taskUnmarked = listOfUserTasks.get(itemNumber - 1);
                    taskUnmarked.unMark();
                    System.out.println("Nice I have marked item number " + itemNumber + "\n" + taskUnmarked.getStatusIcon());

                    break;


                case "deadline":

                    String taskDescription = inputParts[1] + " " + inputParts[2];
                    String by = inputParts[4];
                    Deadline deadline = new Deadline(taskDescription, by);
                    listOfUserTasks.add(deadline);
                    Task.numberOfTasks += 1;
                    System.out.println(deadline);

                    break;

                case "todo":
                    taskDescription = inputParts[1] + " " + inputParts[2];
                    Todo todo = new Todo(taskDescription);
                    listOfUserTasks.add(todo);
                    Task.numberOfTasks += 1;
                    System.out.println(todo);
                    System.out.println();

                    break;

                case "event":
                    taskDescription = inputParts[1] + " " + inputParts[2];
                    String from = inputParts[4] + " " + inputParts[5];
                    String to = inputParts[7];
                    Event event = new Event(taskDescription, from, to);
                    listOfUserTasks.add(event);
                    Task.numberOfTasks += 1;
                    System.out.println(event);

                    break;
                case "delete":
                    int itemNumberToBeDeleted = Integer.parseInt(inputParts[1]);
                    System.out.println("Noted I will delete this task: " + listOfUserTasks.get(itemNumberToBeDeleted));
                    listOfUserTasks.remove(itemNumberToBeDeleted);
                    System.out.println("Now you have " + listOfUserTasks.toArray().length + "tasks.");


                default:
                    System.out.println("added: " + userText);
                    Task userTask = new Task(userText);
                    listOfUserTasks.add(userTask);
                    Task.numberOfTasks += 1;
                    break;

                }
            } catch (DukeException e) {
                System.out.println(e.getMessage());

            } catch (NumberFormatException e) {
                System.out.println("Item number must be an integer!");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Task cannot be blank!");
            } finally {
                System.out.println();
                userText = input.nextLine();
                }
            }
            System.out.println("Bye for now!");
            StringBuilder outputToFile = new StringBuilder();
            for (Task t : listOfUserTasks) {
                outputToFile.append(t.toFileString()).append("\n");
            }
            writeToFile("data/twin.txt", outputToFile.toString());
        }
    }
