package gl2.example.taskmanagementapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import gl2.example.taskmanagementapp.dto.TaskRequestDto;
import gl2.example.taskmanagementapp.dto.TaskResponseDto;
import gl2.example.taskmanagementapp.model.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(target = "status", expression = "java(task.getStatus().name())")
    @Mapping(target = "priority", expression = "java(task.getPriority().name())")
    @Mapping(
            target = "dueDate",
            expression = "java(task.getDueDate() != null ? task.getDueDate().toLocalDate() : null)"
    )
    TaskResponseDto toDto(Task task);

    @Mapping(
            target = "dueDate",
            expression = "java(dto.getDueDate() != null ? dto.getDueDate().atStartOfDay() : null)"
    )
    @Mapping(target = "status", expression = "java(gl2.example.taskmanagementapp.model.Status.valueOf(dto.getStatus()))")
    @Mapping(target = "priority", expression = "java(gl2.example.taskmanagementapp.model.Priority.valueOf(dto.getPriority()))")
    Task toEntity(TaskRequestDto dto);

}
