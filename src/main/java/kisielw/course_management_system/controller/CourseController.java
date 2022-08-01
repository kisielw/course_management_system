package kisielw.course_management_system.controller;

import kisielw.course_management_system.model.Course;
import kisielw.course_management_system.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping(path = "/admin/courses")
    public String showAllCourses(ModelMap modelMap) {
        modelMap.addAttribute("courses", courseService.findAll());
        return "course_list";
    }
}
