package kisielw.course_management_system.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class ClassBlock {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Double durationTime;
}
