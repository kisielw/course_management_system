package kisielw.course_management_system.service.impl;

import kisielw.course_management_system.model.Role;
import kisielw.course_management_system.model.User;
import kisielw.course_management_system.repository.RoleRepository;
import kisielw.course_management_system.repository.UserRepository;
import kisielw.course_management_system.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
        roleRepository.deleteAll();
    }

    @Test
    void shouldAddNewUserToRepository(){
        //given
        Role roleStudent = new Role();
        roleStudent.setName("STUDENT");
        roleRepository.save(roleStudent);

        User user = User.builder()
                .username("user")
                .password("pass")
                .name("Jan")
                .surname("Kowalski")
                .build();

        //when
        userService.save(user, "STUDENT");

        //then
        Assertions.assertEquals(1, userRepository.findAll().size());
        Assertions.assertEquals(true, userRepository.findAll().get(0).isActive());
        Assertions.assertNotEquals("pass", userRepository.findAll().get(0).getPassword());
        Assertions.assertEquals("STUDENT", userRepository.findAll().get(0).getRoles().get(0).getName());

    }
}