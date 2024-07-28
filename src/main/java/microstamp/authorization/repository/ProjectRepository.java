package microstamp.authorization.repository;

import microstamp.authorization.data.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project findByExternalId(UUID externalId);

    //this can be replaced with the default JPA findByUserId if we have the property UserId in Project entity (bidirectional)
    @Query(value = "SELECT * FROM projects p WHERE p.user_id = ?1", nativeQuery = true)
    List<Project> findByUserId(long userId);

    @Query(value = "SELECT * FROM projects p WHERE p.user_id = ?1", nativeQuery = true)
    List<Project> findByUserExternalId(long userExternalId);
}
