package kisielw.course_management_system.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Student {

    public Student(User user) {
        this.user = user;
    }

    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne
    private User user;

    @ManyToMany
    private List<OrganisedCourse> courses;
}
