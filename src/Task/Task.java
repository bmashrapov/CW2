package Task;

import TaskType.Recurrence;
import TaskType.TaskType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Task {
    private long id;
    private String title;
    private String description;
    private TaskType type;
    private Recurrence recurrence;
    private LocalDateTime createdAt;

    private LocalDateTime dueDate;

    public Task(long id, String title, String description, TaskType type, Recurrence recurrence, LocalDateTime createdAt, LocalDateTime dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.recurrence = recurrence;
        this.createdAt = createdAt;
        this.dueDate = dueDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskType getType() {
        return type;
    }

    public Recurrence getRecurrence() {
        return recurrence;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getNextDate() {
        return recurrence.getNextDate(dueDate);
    }

    public abstract boolean appearsIn(LocalDate date);

    public void setId(long id) {
        this.id = id;
    }
    //    @Override
////    public String toString() {
////        return " Type recurrence " + getRecurrence();
////    }
}

