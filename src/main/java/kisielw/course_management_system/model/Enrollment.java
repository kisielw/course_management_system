package kisielw.course_management_system.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Data
@NoArgsConstructor
public class Enrollment {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne
    private User user;

    @OneToOne
    private Course course;

    private boolean accepted;
}
