package kisielw.course_management_system.service.impl;

import kisielw.course_management_system.model.Course;
import kisielw.course_management_system.repository.CourseRepository;
import kisielw.course_management_system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }
}
