import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList toDoList = new ToDoList();

        while (true) {
            System.out.println("\nTo-Do List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    toDoList.addTask(description);
                    break;
                case 2:
                    toDoList.displayTasks();
                    break;
                case 3:
                    System.out.print("Enter task ID to mark as completed: ");
                    int completeId = scanner.nextInt();
                    toDoList.markTaskAsCompleted(completeId);
                    break;
                case 4:
                    System.out.print("Enter task ID to remove: ");
                    int removeId = scanner.nextInt();
                    toDoList.removeTask(removeId);
                    break;
                case 5:
                    System.out.println("Exiting... Tasks saved!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
}