package gl2.example.taskmanagementapp.dto;

import lombok.*;
import java.time.LocalDate;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "TaskRequestDto", description = "DTO for task creation/updating, provided by the client")
public class TaskRequestDto {
    @Schema(description = "Title of the task", example = "Réviser le plan - Aymen ABID")
    private String title;

    @Schema(description = "Description of the task", example = "Passer en revue le code et faire des commentaires")
    private String description;

    @Schema(description = "Due date of the task", example = "2025-05-10")
    private LocalDate dueDate;

    @Schema(description = "Status of the task", example = "TODO")
    private String status;

    @Schema(description = "Priority of the task", example = "HIGH")
    private String priority;
}
