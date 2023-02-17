package TaskType;

import java.time.LocalDateTime;

public interface Recurrence {
    LocalDateTime getNextDate(LocalDateTime createdAt);
}