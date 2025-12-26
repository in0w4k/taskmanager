package se_final.taskmanager.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se_final.taskmanager.dto.TaskCreateDto;
import se_final.taskmanager.dto.TaskResponseDto;
import se_final.taskmanager.entity.enums.TaskStatus;
import se_final.taskmanager.service.TaskService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
public class TaskApi {
    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> getTasksByProject(@RequestParam Long projectId) {
        return new ResponseEntity<>(taskService.getTasksByProject(projectId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> getTaskById(@PathVariable Long id) {
        return new ResponseEntity<>(taskService.getTaskById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TaskResponseDto> addTask(@RequestBody TaskCreateDto dto) {
        return new ResponseEntity<>(taskService.addTask(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDto> updateTask(@PathVariable Long id, @RequestBody TaskCreateDto dto) {
        return new ResponseEntity<>(taskService.updateTask(id, dto), HttpStatus.OK);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<TaskResponseDto> updateStatus(@PathVariable Long id, @RequestParam TaskStatus status) {
        return new ResponseEntity<>(taskService.updateStatus(id, status), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
