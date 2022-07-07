package kisielw.course_management_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/admin/panel")
    public String showAdminPanel() {
        return "admin_panel";
    }

    @GetMapping("/host/panel")
    public String showHostPanel() {
        return "host_panel";
    }

    @GetMapping("/student/panel")
    public String showStudentPanel() {
        return "student_panel";
    }
}
