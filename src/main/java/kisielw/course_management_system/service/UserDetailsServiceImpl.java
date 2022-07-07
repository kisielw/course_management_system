package kisielw.course_management_system.service;

import kisielw.course_management_system.model.User;
import kisielw.course_management_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User userFromDB = userRepository.findByUsername(username);

        if (userFromDB == null) {
            throw new UsernameNotFoundException("Username " + username + " not found in database!");
        }

        return org.springframework.security.core.userdetails.User.builder()
                .username(userFromDB.getUsername())
                .password(userFromDB.getPassword())
                .roles(userFromDB.getRoles()
                        .stream()
                        .map(u -> u.getName())
                        .collect(Collectors.joining()))
                .build();
    }
}
