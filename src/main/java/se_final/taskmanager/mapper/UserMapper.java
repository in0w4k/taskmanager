package se_final.taskmanager.mapper;

import org.mapstruct.Mapper;
import se_final.taskmanager.dto.UserRegisterDto;
import se_final.taskmanager.dto.UserResponseDto;
import se_final.taskmanager.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserRegisterDto dto);

    UserResponseDto toDto(User entity);
}
