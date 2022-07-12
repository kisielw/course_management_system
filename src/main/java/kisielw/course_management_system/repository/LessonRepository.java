package kisielw.course_management_system.repository;

import kisielw.course_management_system.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
}
