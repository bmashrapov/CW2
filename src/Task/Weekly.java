package Task;

import TaskType.Recurrence;
import TaskType.TaskType;

import java.time.LocalDateTime;

public class Weekly extends Task implements Recurrence {
    public Weekly(long id, String title, String description, TaskType type, Recurrence recurrence, LocalDateTime createdAt, LocalDateTime dueDate) {
        super(id, title, description, type, recurrence, createdAt, dueDate);
    }

    @Override
    public LocalDateTime getNextDate(LocalDateTime createdAt) {
        return getDueDate().plusWeeks(1);
    }

    @Override
    public String toString() {
        return " Type recurrence - Weekly ";
    }
}
