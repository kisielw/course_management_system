package kisielw.course_management_system.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private OrganisedClassBlock organisedClassBlock;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;
}
