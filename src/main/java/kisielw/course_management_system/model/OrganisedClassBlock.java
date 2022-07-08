package kisielw.course_management_system.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class OrganisedClassBlock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private ClassBlock classBlock;

    @ManyToOne
    private Host host;

    @OneToOne
    private OrganisedCourse organisedCourse;

    @OneToMany
    private List<Lesson> lessons;

}
