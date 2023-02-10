import Task.Task;
import TeskService.TaskService;
import TaskType.Recurrence;
import java.time.LocalDateTime;
import java.util.Scanner;
import TaskType.TaskType;
import Task.OneTime;
import Task.Daily;
import Task.Weekly;
import Task.Monthly;
import Task.Yearly;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useDelimiter("\\n");
        TaskService taskService = new TaskService();
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("1. Add task");
            System.out.println("2. Remove task");
            System.out.println("3. Show tasks for today");
            System.out.println("4. Show deleted tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scan.next();
                    System.out.print("Enter task description: ");
                    String description = scan.next();
                    System.out.print("Enter task due date (yyyy-MM-dd): ");
                    String dueDate = scan.next();
                    System.out.print("Enter task due time (HH:mm): ");
                    String dueTime = scan.next();
                    String dueDateTime = dueDate + "T" + dueTime;
                    LocalDateTime taskDueDateTime = LocalDateTime.parse(dueDateTime);
                    System.out.print("Enter task type (1 for personal, 2 for work): ");
                    int taskType = scan.nextInt();
                    TaskType type = taskType == 1 ? TaskType.PERSONAL : TaskType.WORK;
                    System.out.print("Enter recurrence type (0 for one-time, 1 for daily, 2 for weekly, 3 for monthly, 4 for yearly): ");
                    int recurrenceType = scan.nextInt();
                    Recurrence recurrence = null;
                    switch (recurrenceType) {
                        case 0:
                            recurrence = new OneTime(0,"","",type,recurrence,taskDueDateTime,taskDueDateTime);
                            break;
                        case 1:
                            recurrence = new Daily(0,"","",type,recurrence,taskDueDateTime,taskDueDateTime);
                            break;
                        case 2:
                            recurrence = new Weekly(0,"","",type,recurrence,taskDueDateTime,taskDueDateTime);
                            break;
                        case 3:
                            recurrence = new Monthly(0,"","",type,recurrence,taskDueDateTime,taskDueDateTime);
                            break;
                        case 4:
                            recurrence = new Yearly(0,"","",type,recurrence,taskDueDateTime,taskDueDateTime);
                            break;
                    }
                    Task task = taskService.createTask(title, description, type, recurrence, taskDueDateTime);
                    System.out.println("Task added with id: " + task.getId());
                    break;
                case 2:
                    taskService.removeTaskPrint();
                    System.out.print("Enter task id: ");
                    long id = scan.nextLong();
                    taskService.removeTask(id);
                    break;
                case 3:
                    taskService.printTasksForToday();
                    break;
                case 4:
                    taskService.printDeletedTasks();
                    break;
                case 5:
                    continueLoop = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        }
        scan.close();
    }
}