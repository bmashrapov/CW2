package Task;

import TaskType.Recurrence;
import TaskType.TaskType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Monthly extends Task implements Recurrence {
    public Monthly(long id, String title, String description, TaskType type, Recurrence recurrence, LocalDateTime createdAt, LocalDateTime dueDate) {
        super(id, title, description, type, recurrence, createdAt, dueDate);
    }

    @Override
    public LocalDateTime getNextDate(LocalDateTime createdAt) {
        return getDueDate().plusMonths(1);
    }

    @Override
    public String toString() {
        return " Type recurrence - Monthly ";
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return getDueDate().toLocalDate().getDayOfMonth() == date.getDayOfMonth();
    }
}
