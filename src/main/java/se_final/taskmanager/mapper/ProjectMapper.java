package se_final.taskmanager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import se_final.taskmanager.dto.ProjectCreateDto;
import se_final.taskmanager.dto.ProjectResponseDto;
import se_final.taskmanager.entity.Project;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    Project toEntity(ProjectCreateDto dto);

    @Mapping(target = "ownerUsername", source = "owner.username")
    ProjectResponseDto toDto(Project entity);
}
