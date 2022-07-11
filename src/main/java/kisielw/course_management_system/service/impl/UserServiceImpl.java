package kisielw.course_management_system.service.impl;

import kisielw.course_management_system.model.Role;
import kisielw.course_management_system.model.User;
import kisielw.course_management_system.repository.RoleRepository;
import kisielw.course_management_system.repository.UserRepository;
import kisielw.course_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public void save(User user) {
        //TODO setActive(false) -> mail do użytkownika z linkiem aktywacyjnym
        user.setActive(true);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(List.of(roleRepository.findByName("STUDENT")));
        userRepository.save(user);
    }
}
