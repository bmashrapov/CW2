package Task;

import TaskType.Recurrence;
import TaskType.TaskType;

import java.time.LocalDateTime;

public class Yearly extends Task implements Recurrence {
    public Yearly(long id, String title, String description, TaskType type, Recurrence recurrence, LocalDateTime createdAt, LocalDateTime dueDate) {
        super(id, title, description, type, recurrence, createdAt, dueDate);
    }

    @Override
    public LocalDateTime getNextDate(LocalDateTime createdAt) {
        return getDueDate().plusYears(1);
    }
    @Override
    public String toString() {
        return " Type recurrence - Yearly ";
    }
}
