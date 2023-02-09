package Task;

import TaskType.Recurrence;
import TaskType.TaskType;

import java.time.LocalDateTime;

public class Monthly extends Task implements Recurrence {
    public Monthly(long id, String title, String description, TaskType type, Recurrence recurrence, LocalDateTime createdAt, LocalDateTime dueDate) {
        super(id, title, description, type, recurrence, createdAt, dueDate);
    }

    @Override
    public LocalDateTime getNextDate(LocalDateTime createdAt) {
        return createdAt.plusMonths(1);
    }
}
