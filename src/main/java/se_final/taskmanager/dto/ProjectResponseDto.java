package se_final.taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponseDto {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private String ownerUsername;
}
