package Task;

import TaskType.Recurrence;

import java.time.LocalDateTime;

public class Daily implements Recurrence {
    @Override
    public LocalDateTime getNextDate(LocalDateTime createdAt) {
        return createdAt.plusDays(1);
    }
}
