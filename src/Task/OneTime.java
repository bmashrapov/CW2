package Task;

import TaskType.Recurrence;
import TaskType.TaskType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTime extends Task implements Recurrence {
    public OneTime(long id, String title, String description, TaskType type, Recurrence recurrence, LocalDateTime createdAt, LocalDateTime dueDate) {
        super(id, title, description, type, recurrence, createdAt, dueDate);
    }

    @Override
    public LocalDateTime getNextDate(LocalDateTime createdAt) {
        return null;
    }

    @Override
    public String toString() {
        return " Type recurrence - One Time ";
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return getDueDate().toLocalDate().equals(date);
    }
}
