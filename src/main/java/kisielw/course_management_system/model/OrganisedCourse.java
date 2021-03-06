package kisielw.course_management_system.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class OrganisedCourse{

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Course course;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    @OneToMany
    private List<OrganisedClassBlock> classBlocks;

    @ManyToMany
    private List<Student> students;


}
