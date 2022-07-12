package kisielw.course_management_system.service.impl;

import kisielw.course_management_system.model.Student;
import kisielw.course_management_system.model.User;
import kisielw.course_management_system.repository.StudentRepository;
import kisielw.course_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void save(User user) {
        Student student = new Student(user);
        studentRepository.save(student);
    }
}
