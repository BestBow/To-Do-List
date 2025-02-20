import java.io.*;
import java.util.*;
class ToDoList {
    private ArrayList<Task> tasks;
    private int taskCounter;
    private static final String FILE_NAME = "tasks.txt";

    public ToDoList() {
        this.tasks = new ArrayList<>();
        this.taskCounter = 1;
        loadTasksFromFile();
    }

    public void addTask(String description) {
        Task task = new Task(taskCounter, description, false);
        tasks.add(task);
        taskCounter++;
        saveTasksToFile();
        System.out.println("Task added successfully!");
    }

    public void removeTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
        saveTasksToFile();
        System.out.println("Task removed successfully!");
    }

    public void markTaskAsCompleted(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.markAsCompleted();
                saveTasksToFile();
                System.out.println("Task marked as completed!");
                return;
            }
        }
        System.out.println("Task not found!");
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\nTo-Do List:");
            for (Task task : tasks) {
                task.displayTask();
            }
        }
    }

    private void saveTasksToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                writer.println(task.toFileFormat());
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks to file!");
        }
    }

    private void loadTasksFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Task task = Task.fromFileFormat(line);
                tasks.add(task);
                taskCounter = Math.max(taskCounter, task.getId() + 1);
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks from file!");
        }
    }
}