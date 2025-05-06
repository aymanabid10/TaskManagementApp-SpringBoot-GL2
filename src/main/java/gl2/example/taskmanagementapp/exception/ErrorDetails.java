package gl2.example.taskmanagementapp.exception;

import lombok.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String details;
}
