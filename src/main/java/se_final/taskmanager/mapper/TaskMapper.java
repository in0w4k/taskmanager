package se_final.taskmanager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import se_final.taskmanager.dto.TaskCreateDto;
import se_final.taskmanager.dto.TaskResponseDto;
import se_final.taskmanager.entity.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task toEntity(TaskCreateDto dto);

    @Mapping(target = "assigneeUsername", source = "assignee.username")
    TaskResponseDto toDto(Task entity);
}
