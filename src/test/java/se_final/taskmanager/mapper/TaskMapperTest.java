package se_final.taskmanager.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se_final.taskmanager.dto.TaskCreateDto;
import se_final.taskmanager.dto.TaskResponseDto;
import se_final.taskmanager.entity.Task;
import se_final.taskmanager.entity.User;
import se_final.taskmanager.entity.enums.TaskPriority;
import se_final.taskmanager.entity.enums.TaskStatus;

@SpringBootTest
public class TaskMapperTest {
    @Autowired
    private TaskMapper taskMapper;

    @Test
    void convertDtoToEntityTest() {
        TaskCreateDto dto = new TaskCreateDto("TaskTest", "Desc", TaskPriority.HIGH, 1L, 2L);
        Task entity = taskMapper.toEntity(dto);

        Assertions.assertNotNull(entity);
        Assertions.assertEquals(dto.getTitle(), entity.getTitle());
        Assertions.assertEquals(dto.getDescription(), entity.getDescription());
        Assertions.assertEquals(dto.getPriority(), entity.getPriority());
    }

    @Test
    void convertEntityToDtoTest() {
        User assignee = User.builder()
                .username("assigneeUser")
                .build();

        Task entity = Task.builder()
                .id(10L)
                .title("TaskTest")
                .description("Desc")
                .status(TaskStatus.IN_PROGRESS)
                .priority(TaskPriority.LOW)
                .assignee(assignee)
                .build();

        TaskResponseDto dto = taskMapper.toDto(entity);

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(entity.getId(), dto.getId());
        Assertions.assertEquals(entity.getTitle(), dto.getTitle());
        Assertions.assertEquals(entity.getStatus(), dto.getStatus());
        Assertions.assertEquals("assigneeUser", dto.getAssigneeUsername());
    }
}