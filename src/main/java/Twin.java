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
        String userText = input.nextLine();
        String [] listOfUserTexts= new String [100];
        int i=0;

        while (!userText.equalsIgnoreCase("bye")) {
            if (userText.equalsIgnoreCase("list")) {
                for (int x = 0; x < i; x++) {
                    System.out.println(listOfUserTexts[x]);
                }
                System.out.println();
                userText = input.nextLine();
            }
            else if (userText.toLowerCase().startsWith("mark")) {
                String[] parts = userText.split(" ");
                int itemNumber = Integer.parseInt(parts[1]);
                listOfUserTexts[itemNumber-1]="[X]"+listOfUserTexts[itemNumber-1].split(" ")[2]+" "+listOfUserTexts[itemNumber-1].split(" ")[3];
                System.out.println("Nice I have marked item number "+itemNumber+"\n"+listOfUserTexts[itemNumber-1]);
                System.out.println();
                userText=input.nextLine();



            }

            else {
                System.out.println("added: " + userText);
                listOfUserTexts[i] = ("[ ] "+userText);
                i += 1;
                System.out.println();
                userText = input.nextLine();
            }



        }
        System.out.println("Bye for now!");
    }
}
