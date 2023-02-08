package Task;

import TaskType.Recurrence;

import java.time.LocalDateTime;

public class Yearly implements Recurrence {
    @Override
    public LocalDateTime getNextDate(LocalDateTime createdAt) {
        return createdAt.plusYears(1);
    }
}
