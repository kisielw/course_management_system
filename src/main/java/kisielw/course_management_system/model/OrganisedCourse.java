package kisielw.course_management_system.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class OrganisedCourse{

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Course course;

    private LocalDate startDate;

}
