package Task;

import TaskType.Recurrence;

import java.time.LocalDateTime;

public class OneTime implements Recurrence {
    @Override
    public LocalDateTime getNextDate(LocalDateTime createdAt) {
        return null;
    }
}
