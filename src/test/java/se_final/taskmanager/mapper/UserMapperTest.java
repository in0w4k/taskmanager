package se_final.taskmanager.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se_final.taskmanager.dto.UserRegisterDto;
import se_final.taskmanager.dto.UserResponseDto;
import se_final.taskmanager.entity.User;
import se_final.taskmanager.entity.enums.Role;

@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void convertDtoToEntityTest() {
        UserRegisterDto dto = new UserRegisterDto("testUser", "testPass", "test@mail.com");
        User entity = userMapper.toEntity(dto);

        Assertions.assertNotNull(entity);
        Assertions.assertEquals(dto.getUsername(), entity.getUsername());
        Assertions.assertEquals(dto.getEmail(), entity.getEmail());
    }

    @Test
    void convertEntityToDtoTest() {
        User entity = User.builder()
                .id(1L)
                .username("testUser")
                .email("test@mail.com")
                .role(Role.ROLE_USER)
                .build();

        UserResponseDto dto = userMapper.toDto(entity);

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(entity.getId(), dto.getId());
        Assertions.assertEquals(entity.getUsername(), dto.getUsername());
        Assertions.assertEquals(entity.getEmail(), dto.getEmail());
        Assertions.assertEquals(entity.getRole().name(), dto.getRole());
    }
}