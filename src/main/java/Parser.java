// Parser.java
public class Parser {

    // static parse helper — throws TwinException for user-facing errors
    public static Command parse(String userText) throws TwinException {
        if (userText == null || userText.trim().isEmpty()) {
            throw new TwinException("Please enter a valid input! Input cannot be blank!");
        }

        String trimmed = userText.trim();
        // split into command and the rest (arguments)
        String[] parts = trimmed.split(" ", 2);
        String command = parts[0].toLowerCase();
        String args = parts.length > 1 ? parts[1].trim() : "";

        switch (command) {
        case "list":
            return new ListCommand();


        case "mark":
            if (args.isEmpty()) {
                throw new TwinException("Please add what item number to mark.");
            }
            try {
                int idx = Integer.parseInt(args);
                return new MarkCommand(idx);
            } catch (NumberFormatException e) {
                throw new TwinException("Please give me a valid number to mark!");
            }

        case "unmark":
            if (args.isEmpty()) {
                throw new TwinException("Please add what item number to unmark.");
            }
            try {
                int idx = Integer.parseInt(args);
                return new UnMarkCommand(idx);
            } catch (NumberFormatException e) {
                throw new TwinException("Please give me a valid number to unmark!");
            }

        case "todo":
            if (args.isEmpty()) {
                throw new TwinException("The description of a todo cannot be empty.");
            }
            return new AddTodoCommand(args);

        case "deadline":
            // require " by " and use limit 2 so description can contain "by"
            String[] dp = trimmed.split(" by ", 2);
            if (dp.length < 2) {
                throw new TwinException("Usage: deadline <description> by <time>");
            }
            String dDesc = dp[0].substring("deadline".length()).trim();
            String by = dp[1].trim();
            if (dDesc.isEmpty() || by.isEmpty()) {
                throw new TwinException("Usage: deadline <description> by <time>");
            }
            return new AddDeadlineCommand(dDesc, by);

        case "event":
            String[] ep = trimmed.split(" from ", 2);
            if (ep.length < 2) {
                throw new TwinException("Usage: event <description> from <start> to <end>");
            }
            String eDesc = ep[0].substring("event".length()).trim();
            String[] times = ep[1].split(" to ", 2);
            if (eDesc.isEmpty() || times.length < 2 || times[0].trim().isEmpty() || times[1].trim().isEmpty()) {
                throw new TwinException("Usage: event <description> from <start> to <end>");
            }
            return new AddEventCommand(eDesc, times[0].trim(), times[1].trim());

        case "delete":
            if (args.isEmpty()) {
                throw new TwinException("Please provide the task number to delete.");
            }
            try {
                int idx = Integer.parseInt(args);
                return new DeleteCommand(idx);
            } catch (NumberFormatException e) {
                throw new TwinException("Please give me a valid number to delete!");
            }

        case "exit":
            Command c = new ExitCommand();
            return c;

        default:
            throw new TwinException("Unknown command: " + command);
        }
    }
}
