package se_final.taskmanager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se_final.taskmanager.dto.ProjectCreateDto;
import se_final.taskmanager.dto.ProjectResponseDto;
import se_final.taskmanager.entity.Project;
import se_final.taskmanager.entity.User;
import se_final.taskmanager.mapper.ProjectMapper;
import se_final.taskmanager.rep.ProjectRepository;
import se_final.taskmanager.rep.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMapper projectMapper;

    public ProjectResponseDto addProject(ProjectCreateDto dto, String ownerUsername) {
        User owner = userRepository.findByUsername(ownerUsername)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (projectRepository.existsByNameAndOwnerUsername(dto.getName(), ownerUsername)) {
            throw new RuntimeException("Project with this name already exists");
        }
        Project project = projectMapper.toEntity(dto);
        project.setOwner(owner);
        project.setMembers(new HashSet<>(Set.of(owner)));
        Project savedProject = projectRepository.save(project);
        return projectMapper.toDto(savedProject);
    }

    public ProjectResponseDto getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        return projectMapper.toDto(project);
    }

    public List<ProjectResponseDto> getAllProjects() {
        return projectRepository.findAll().stream()
                .map(projectMapper::toDto)
                .toList();
    }

    public ProjectResponseDto updateProject(Long id, ProjectCreateDto dto) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        if (dto.getName() != null) project.setName(dto.getName());
        if (dto.getDescription() != null) project.setDescription(dto.getDescription());
        Project updatedProject = projectRepository.save(project);
        return projectMapper.toDto(updatedProject);
    }

    public void deleteProject(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        projectRepository.delete(project);
    }

    public ProjectResponseDto addMember(Long projectId, String usernameToAdd) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        User user = userRepository.findByUsername(usernameToAdd)
                .orElseThrow(() -> new RuntimeException("User not found"));
        project.getMembers().add(user);
        Project addedProject = projectRepository.save(project);
        return projectMapper.toDto(addedProject);
    }
}
