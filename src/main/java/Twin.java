import java.util.Scanner;
import java.util.Arrays;


public class Twin {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello I am Twin\nNice to meet you\nWhat can I do for you?");
        Scanner input=new Scanner(System.in);
        System.out.println();
        String userText = input.nextLine();
        Task[] listOfUserTasks= new Task[100];
        int numberOfTasksInlist=0;

        while (!userText.equalsIgnoreCase("bye")) {
            String[] inputParts;
            if (userText.equalsIgnoreCase("list")) {
                for (int x = 0; x < numberOfTasksInlist; x++) {
                    Task taskPrinted = listOfUserTasks[x];
                    System.out.println(taskPrinted.getStatusIcon());
                }
            } else if (userText.toLowerCase().startsWith("mark")) {
                inputParts = userText.split(" ");
                int itemNumber = Integer.parseInt(inputParts[1]);
                Task taskMarked = listOfUserTasks[itemNumber - 1];
                taskMarked.markAsDone();
                System.out.println("Nice I have marked item number " + itemNumber + "\n" + taskMarked.getStatusIcon());

            } else if (userText.toLowerCase().startsWith("deadline")) {
                inputParts = userText.split(" ");
                String taskDescription = inputParts[1] + " " + inputParts[2];
                String by = inputParts[4];
                Deadline deadline = new Deadline(taskDescription,by);
                listOfUserTasks[numberOfTasksInlist] = deadline;
                numberOfTasksInlist += 1;
                System.out.println(deadline);

            } else if (userText.toLowerCase().startsWith("todo")) {
                inputParts = userText.split(" ");
                String taskDescription = inputParts[1] + " " + inputParts[2];
                Todo todo = new Todo(taskDescription);
                listOfUserTasks[numberOfTasksInlist] = todo;
                numberOfTasksInlist += 1;
                System.out.println(todo);

            } else if (userText.toLowerCase().startsWith("event")) {
                inputParts = userText.split(" ");
                String taskDescription = inputParts[1] + " " + inputParts[2];
                String from = inputParts[4] + " " + inputParts[5];
                String to = inputParts[7];
                Event event = new Event(taskDescription, from, to);
                listOfUserTasks[numberOfTasksInlist] = event;
                numberOfTasksInlist += 1;
                System.out.println(event);

            } else {
                System.out.println("added: " + userText);
                Task userTask = new Task(userText);
                listOfUserTasks[numberOfTasksInlist] = userTask;
                numberOfTasksInlist += 1;
            }
            System.out.println();
            userText = input.nextLine();


        }

        System.out.println("Bye for now!");
    }
}
