import java.util.Scanner;

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
        String userTask = input.nextLine();
        String [] listOfUserTasks= new String [100];
        int numberTasksInlist=0;

        while (!userTask.equalsIgnoreCase("bye")) {
            if (userTask.equalsIgnoreCase("list")) {
                for (int x = 0; x < numberTasksInlist; x++) {
                    System.out.println(listOfUserTasks[x]);
                }
                System.out.println();
                userTask = input.nextLine();
            } else if (userTask.toLowerCase().startsWith("mark")) {
                String[] parts = userTask.split(" ");
                int itemNumber = Integer.parseInt(parts[1]);
                listOfUserTasks[itemNumber-1]="[X]"+listOfUserTasks[itemNumber-1].split(" ")[2]+" "+listOfUserTasks[itemNumber-1].split(" ")[3];
                System.out.println("Nice I have marked item number "+itemNumber+"\n"+listOfUserTasks[itemNumber-1]);
                System.out.println();
                userTask=input.nextLine();

            } else {
                System.out.println("added: " + userTask);
                listOfUserTasks[numberTasksInlist] = ("[ ] "+userTask);
                numberTasksInlist += 1;
                System.out.println();
                userTask = input.nextLine();
            }



        }

        System.out.println("Bye for now!");
    }
}
