package kisielw.course_management_system.service;

import kisielw.course_management_system.model.User;
import org.springframework.stereotype.Service;

public interface UserService {

    void save(User user, String roleName);

    boolean existsByUsername(String username);
}
