package microstamp.authorization.data;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity(name = "Project")
@Table(name = "projects")
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID externalId;

    private String name;

    private String description;

}
