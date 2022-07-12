package kisielw.course_management_system.repository;

import kisielw.course_management_system.model.Host;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostRepository extends JpaRepository<Host, Integer> {
}
