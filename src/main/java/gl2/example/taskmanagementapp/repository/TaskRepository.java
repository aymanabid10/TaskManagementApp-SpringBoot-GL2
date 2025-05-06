package gl2.example.taskmanagementapp.repository;

import gl2.example.taskmanagementapp.model.Task;
import gl2.example.taskmanagementapp.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(Status status);
    List<Task> findByDueDateBefore(LocalDateTime dateTime);
    List<Task> findByTitleContainingIgnoreCase(String keyword);
}
