package TeskService;

import Task.Task;

import java.time.LocalDate;
import java.util.*;

public class TaskService {
    private Map<Long, Task> tasks = new HashMap<>();
    private Map<Long, Task> deletedTasks = new HashMap<>();
    private long taskId = 0L;

    public void createTask(Task task) {
        task.setId(++taskId);
        tasks.put(task.getId(), task);
//        Task tasks = new Task(++taskId, title, description, type, recurrence, LocalDateTime.now(), dueDate);
//        tasks.put(taskId, task);

    }

    public void removeTaskPrint() {
        if (!tasks.isEmpty()) {
            System.out.println("Tasks available for deletion: ");
            for (Task task : tasks.values()) {
                System.out.println("Task id: " + task.getId() + " Title: " + task.getTitle() + " Date: " + task.getDueDate());
            }
        } else {
            System.out.println("No tasks! Type 1 and hit enter to leave the delete task menu.");
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

    public void printTasksForSpecificDay(LocalDate date) {
        Collection<Task> dayTasks = getTasksForDay(date);
        if (dayTasks.isEmpty()) {
            System.out.println("There are no tasks for " + date + ", rest!");
        } else {
            System.out.println("Tasks for " + date + ": ");
            for (Task task : dayTasks) {
                System.out.println("Task id: " + task.getId() + " Title: " + task.getTitle() + " Description: " + task.getDescription() + " Time: " + task.getDueDate().toLocalTime() + task.getRecurrence() + " Next due date: " + task.getNextDate());
            }
        }
    }

    public Collection<Task> getTasksForDay(LocalDate date) {
        List<Task> dayTasks = new ArrayList<>();
//        for (int i = 0; i < tasks.size()+1; i++) {
//            if (tasks.get(i).appearsIn(date)) {
//                dayTasks.add(tasks.get(i));
        for (Task task : tasks.values()) {
            if (task.appearsIn(date)) {
                dayTasks.add(task);
            } else {
                LocalDate nextDate = LocalDate.from(task.getNextDate());
                while (nextDate.isBefore(date)) {
                    nextDate = LocalDate.from(task.getNextDate());
                }
                if (nextDate.equals(date)) {
                    dayTasks.add(task);
                }
            }
        }
        return dayTasks;
    }

//public List<Task> getTasksForDay(LocalDate date) {
//    List<Task> dayTasks = new ArrayList<>();
//    for (Task task : tasks.values()) {
//        if (task.appearsIn(date)) {
//            dayTasks.add(task);
//        }
//        LocalDate nextDate = task.getNextDate();
//        while (nextDate.isBefore(date.plusDays(1))) {
//            if (task.appearsIn(nextDate)) {
//                dayTasks.add(task);
//            }
//            nextDate = task.getNextDate();
//        }
//    }
//    return dayTasks;
//}
//public Collection<Task> getTasksForDay(LocalDate date) {                                                              // получение списка задач по текущей дате
//    ArrayList<Task> list = new ArrayList<>();
//    for (int i = 1; i < tasks.size () + 1; i++) {
//        if (tasks.get ( i ).appearsIn ( date )) {
//            list.add ( tasks.get ( i ) );
//        }
//    }
//    if (list.isEmpty ()){
//        System.out.println ("На сегодня у вас нет задач");
//    }
//    return list;
//}
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

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }
}

