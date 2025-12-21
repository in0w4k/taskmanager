package se_final.taskmanager.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se_final.taskmanager.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    boolean existsByNameAndOwnerUsername(String name, String username);
}
