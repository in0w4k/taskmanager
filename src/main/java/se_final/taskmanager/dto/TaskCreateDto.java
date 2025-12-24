package se_final.taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import se_final.taskmanager.entity.enums.TaskPriority;
import se_final.taskmanager.entity.enums.TaskStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskCreateDto {
    private String title;
    private String description;
    private TaskPriority priority;
    private Long projectId;
    private Long assigneeId;
}