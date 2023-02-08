package Task;

import TaskType.Recurrence;

import java.time.LocalDateTime;

public class Monthly implements Recurrence {
    @Override
    public LocalDateTime getNextDate(LocalDateTime createdAt) {
        return createdAt.plusMonths(1);
    }
}
