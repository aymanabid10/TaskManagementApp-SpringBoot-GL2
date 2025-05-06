package gl2.example.taskmanagementapp.service;

import gl2.example.taskmanagementapp.dto.TaskRequestDto;
import gl2.example.taskmanagementapp.dto.TaskResponseDto;
import java.util.List;

public interface TaskService {
    TaskResponseDto createTask(TaskRequestDto dto);
    TaskResponseDto getTaskById(Long id);
    List<TaskResponseDto> getAllTasks();
    TaskResponseDto updateTask(Long id, TaskRequestDto dto);
    void deleteTask(Long id);
    List<TaskResponseDto> getTasksByStatus(String status);
    List<TaskResponseDto> getOverdueTasks();
    List<TaskResponseDto> searchTasks(String keyword);
}
