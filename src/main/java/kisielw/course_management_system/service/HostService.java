package kisielw.course_management_system.service;

import kisielw.course_management_system.model.Host;
import kisielw.course_management_system.model.User;

import java.util.List;

public interface HostService {

    List<Host> findAll();

    void save(User user);

}
