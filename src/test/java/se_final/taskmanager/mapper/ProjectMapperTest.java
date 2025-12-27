package se_final.taskmanager.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se_final.taskmanager.dto.ProjectCreateDto;
import se_final.taskmanager.dto.ProjectResponseDto;
import se_final.taskmanager.entity.Project;
import se_final.taskmanager.entity.User;

import java.time.LocalDateTime;
import java.util.Set;

@SpringBootTest
public class ProjectMapperTest {
    @Autowired
    private ProjectMapper projectMapper;

    @Test
    void convertDtoToEntityTest() {
        ProjectCreateDto dto = new ProjectCreateDto("ProjectTest", "Project Description Test");
        Project entity = projectMapper.toEntity(dto);

        Assertions.assertNotNull(entity);
        Assertions.assertEquals(dto.getName(), entity.getName());
        Assertions.assertEquals(dto.getDescription(), entity.getDescription());
    }

    @Test
    void convertEntityToDtoTest() {
        User owner = User.builder()
                .username("ownerUser")
                .build();

        User member = User.builder()
                .username("memberUser")
                .build();

        Project entity = Project.builder()
                .id(1L)
                .name("ProjectTest")
                .description("Project Description Test")
                .createdAt(LocalDateTime.now())
                .owner(owner)
                .members(Set.of(member))
                .build();

        ProjectResponseDto dto = projectMapper.toDto(entity);

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(entity.getId(), dto.getId());
        Assertions.assertEquals(entity.getName(), dto.getName());
        Assertions.assertEquals(entity.getDescription(), dto.getDescription());
        Assertions.assertEquals(entity.getCreatedAt(), dto.getCreatedAt());

        Assertions.assertEquals("ownerUser", dto.getOwnerUsername());

        Assertions.assertEquals(1, dto.getMemberUsernames().size());
        Assertions.assertTrue(dto.getMemberUsernames().contains("memberUser"));
    }
}