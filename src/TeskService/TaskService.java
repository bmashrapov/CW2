package TeskService;

import TaskType.Recurrence;
import Task.Task;
import TaskType.TaskType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class TaskService {
    private Map<Long, Task> tasks = new HashMap<>();
    private Map<Long, Task> deletedTasks = new HashMap<>();
    private long taskId = 0L;

    public Task createTask(String title, String description, TaskType type, Recurrence recurrence, LocalDateTime dueDate) {
        Task task = new Task(++taskId, title, description, type, recurrence, LocalDateTime.now(), dueDate);
        tasks.put(taskId, task);
        return task;
    }

    public void removeTaskPrint() {
        if (!tasks.isEmpty()) {
            System.out.println("Tasks available for deletion: ");
            for (Task task : tasks.values()) {
                System.out.println("Task id: " + task.getId() + " Title: " + task.getTitle() + " Date: " + task.getDueDate());
            }
        } else {
            System.out.println("No tasks!");
        }
    }

    public void removeTask(long id) {
        if (tasks.containsKey(id)) {
            System.out.println("Deleting task with id " + id);
            deletedTasks.put(id, tasks.get(id));
            tasks.remove(id);
            System.out.println("Task removed with id: " + id);
        } else {
            System.out.println("No task found with id " + id);
        }
    }

    public void printDeletedTasks() {
        if (!deletedTasks.isEmpty()) {
            System.out.println("Deleted tasks: ");
            for (Task task : deletedTasks.values()) {
                System.out.println("Task id: " + task.getId() + " Title: " + task.getTitle() + " Date: " + task.getDueDate());
            }
        } else {
            System.out.println("No deleted tasks!");
        }
    }

    public void printTasksForToday() {
        List<Task> todayTasks = getTasksForToday();
        if (todayTasks.isEmpty()) {
            System.out.println("There are no tasks for today, rest!");
        } else {
            System.out.println("Tasks for today: ");
            for (Task task : todayTasks) {
                System.out.println("Task id: " + task.getId() + " Title: " + task.getTitle() + "Description: " + task.getDescription() + " Time: " + task.getDueDate().toLocalTime());
            }
        }
    }

    public List<Task> getTasksForToday() {
        List<Task> todayTasks = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for (Task task : tasks.values()) {
            if (task.getDueDate().toLocalDate().equals(today)) {
                todayTasks.add(task);
            }
        }
        return todayTasks;
    }

    public Map<Long, Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        return "TaskService{" +
                "tasks=" + getTasks() +
                ", taskId=" + taskId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskService that = (TaskService) o;
        return taskId == that.taskId && Objects.equals(tasks, that.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tasks, taskId);
    }

    public Map<Long, Task> getDeletedTasks() {
        return deletedTasks;
    }
}

