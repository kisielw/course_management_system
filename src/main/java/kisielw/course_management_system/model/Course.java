package kisielw.course_management_system.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Course {

    @GeneratedValue
    @Id
    private Integer id;

    private String name;

    @OneToMany
    private List<ClassBlock> classBlocks;

    //TODO automatyczne sumowanie czasów trwania każdego z bloków, chyba w serwisie to zrobię przy dodawaniu kursu przez admina
    //private Double durationTime;

}
