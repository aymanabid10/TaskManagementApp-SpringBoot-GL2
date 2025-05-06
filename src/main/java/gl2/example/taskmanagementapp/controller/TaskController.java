package gl2.example.taskmanagementapp.controller;

import org.springframework.web.bind.annotation.*;
import gl2.example.taskmanagementapp.dto.TaskRequestDto;
import gl2.example.taskmanagementapp.dto.TaskResponseDto;
import gl2.example.taskmanagementapp.service.TaskService;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @Operation(summary = "Create a new task")
    @PostMapping
    public TaskResponseDto createTask(@RequestBody TaskRequestDto dto) {
        return service.createTask(dto);
    }

    @Operation(summary = "Get a task by ID")
    @GetMapping("/{id}")
    public TaskResponseDto getTask(@PathVariable Long id) {
        return service.getTaskById(id);
    }

    @Operation(summary = "Get all tasks")
    @GetMapping
    public List<TaskResponseDto> getAllTasks() {
        return service.getAllTasks();
    }

    @Operation(summary = "Update a task")
    @PutMapping("/{id}")
    public TaskResponseDto updateTask(@PathVariable Long id, @RequestBody TaskRequestDto dto){
        return service.updateTask(id, dto);
    }

    @Operation(summary = "Delete a task")
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
    }

    @Operation(summary = "Get tasks by status")
    @GetMapping("/status/{status}")
    public List<TaskResponseDto> getByStatus(@PathVariable String status) {
        return service.getTasksByStatus(status);
    }

    @Operation(summary = "Get overdue tasks")
    @GetMapping("/overdue")
    public List<TaskResponseDto> getOverdueTasks() {
        return service.getOverdueTasks();
    }

    @Operation(summary = "Search tasks by title")
    @GetMapping("/search")
    public List<TaskResponseDto> searchTasks(@RequestParam String q) {
        return service.searchTasks(q);
    }
}
