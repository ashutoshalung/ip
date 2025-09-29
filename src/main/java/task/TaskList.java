package task;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    // Constructor for a fresh list
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    // Constructor for when Storage loads tasks from file
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public Task get(int index) {
        return tasks.get(index);
    }

    public Task remove(int index) {
        return tasks.remove(index);
    }

    public int size() {
        return tasks.size();
    }
    public ArrayList<Task> getAllTasks() {
        return tasks;
    }
}
