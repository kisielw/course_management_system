package kisielw.course_management_system.service.impl;

import kisielw.course_management_system.model.Host;
import kisielw.course_management_system.model.User;
import kisielw.course_management_system.repository.HostRepository;
import kisielw.course_management_system.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostServiceImpl implements HostService {

    @Autowired
    private HostRepository hostRepository;

    @Override
    public List<Host> findAll() {
        return hostRepository.findAll();
    }

    @Override
    public void save(User user) {
        Host host = new Host(user);
        hostRepository.save(host);
        //TODO hasło tymczasowe - wymuszenie zmiany przy pierwszym logowaniu
    }
}
