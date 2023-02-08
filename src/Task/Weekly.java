package Task;

import TaskType.Recurrence;

import java.time.LocalDateTime;

public class Weekly implements Recurrence {
    @Override
    public LocalDateTime getNextDate(LocalDateTime createdAt) {
        return createdAt.plusWeeks(1);
    }
}
