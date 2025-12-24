package se_final.taskmanager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import se_final.taskmanager.dto.ProjectCreateDto;
import se_final.taskmanager.dto.ProjectResponseDto;
import se_final.taskmanager.entity.Project;
import se_final.taskmanager.entity.User;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    Project toEntity(ProjectCreateDto dto);

    @Mapping(target = "ownerUsername", source = "owner.username")
    @Mapping(target = "memberUsernames", source = "members")
    ProjectResponseDto toDto(Project entity);

    default List<String> mapMembers(Set<User> members) {
        if (members == null) {
            return List.of();
        }
        return members.stream()
                .map(User::getUsername)
                .toList();
    }
}
