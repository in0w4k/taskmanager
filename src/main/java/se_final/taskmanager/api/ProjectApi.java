package se_final.taskmanager.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se_final.taskmanager.dto.ProjectCreateDto;
import se_final.taskmanager.dto.ProjectResponseDto;
import se_final.taskmanager.service.ProjectService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects")
public class ProjectApi {
    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectResponseDto>> getAllProjects() {
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponseDto> getProjectById(@PathVariable Long id) {
        return new ResponseEntity<>(projectService.getProjectById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ProjectResponseDto> addProject(@RequestBody ProjectCreateDto dto, @RequestParam String username) {
        return new ResponseEntity<>(projectService.addProject(dto, username), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponseDto> updateProject(@PathVariable Long id, @RequestBody ProjectCreateDto dto) {
        return new ResponseEntity<>(projectService.updateProject(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{id}/members")
    public ResponseEntity<ProjectResponseDto> addMember(@PathVariable Long id, @RequestParam String username) {
        return new ResponseEntity<>(projectService.addMember(id, username), HttpStatus.OK);
    }
}
