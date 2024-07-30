package microstamp.authorization.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Types;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "Analysis")
@Table(name = "analyses")
@Data
public class Analysis {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(Types.VARCHAR)
    private UUID id;

    private String name;

    private String description;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Analysis(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
