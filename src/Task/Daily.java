package Task;

import TaskType.Recurrence;
import TaskType.TaskType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Daily extends Task implements Recurrence {
    public Daily(long id, String title, String description, TaskType type, Recurrence recurrence, LocalDateTime createdAt, LocalDateTime dueDate) {
        super(id, title, description, type, recurrence, createdAt, dueDate);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return true;
    }

    @Override
    public LocalDateTime getNextDate(LocalDateTime createdAt) {
        return getDueDate().plusDays(1);
    }

    @Override
    public String toString() {
        return " Type recurrence - Daily ";
    }
}
