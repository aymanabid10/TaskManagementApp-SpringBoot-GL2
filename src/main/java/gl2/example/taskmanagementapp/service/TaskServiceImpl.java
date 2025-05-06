package gl2.example.taskmanagementapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import gl2.example.taskmanagementapp.dto.TaskRequestDto;
import gl2.example.taskmanagementapp.dto.TaskResponseDto;
import gl2.example.taskmanagementapp.model.Task;
import gl2.example.taskmanagementapp.repository.TaskRepository;
import gl2.example.taskmanagementapp.mapper.TaskMapper;
import gl2.example.taskmanagementapp.exception.ResourceNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;
    private final TaskMapper mapper;

    public TaskServiceImpl(TaskRepository repository, TaskMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TaskResponseDto createTask(TaskRequestDto dto) {
        Task task = mapper.toEntity(dto);
        task = repository.save(task);
        return mapper.toDto(task);
    }

    @Override
    public TaskResponseDto getTaskById(Long id) {
        Task task = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Task", "id", id));
        return mapper.toDto(task);
    }

    @Override
    public List<TaskResponseDto> getAllTasks() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public TaskResponseDto updateTask(Long id, TaskRequestDto dto) {
        Task task = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Task", "id", id));
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setDueDate(dto.getDueDate() != null ? dto.getDueDate().atStartOfDay() : null);
        task.setStatus(gl2.example.taskmanagementapp.model.Status.valueOf(dto.getStatus()));
        task.setPriority(gl2.example.taskmanagementapp.model.Priority.valueOf(dto.getPriority()));
        return mapper.toDto(repository.save(task));
    }

    @Override
    public void deleteTask(Long id) {
        Task task = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Task", "id", id));
        repository.delete(task);
    }

    @Override
    public List<TaskResponseDto> getTasksByStatus(String status) {
        gl2.example.taskmanagementapp.model.Status st = gl2.example.taskmanagementapp.model.Status.valueOf(status);
        return repository.findByStatus(st).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<TaskResponseDto> getOverdueTasks() {
        return repository.findByDueDateBefore(LocalDateTime.now()).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<TaskResponseDto> searchTasks(String keyword) {
        return repository.findByTitleContainingIgnoreCase(keyword).stream().map(mapper::toDto).collect(Collectors.toList());
    }

}
