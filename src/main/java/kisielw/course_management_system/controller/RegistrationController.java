package kisielw.course_management_system.controller;

import kisielw.course_management_system.model.User;
import kisielw.course_management_system.repository.UserRepository;
import kisielw.course_management_system.service.AutologinService;
import kisielw.course_management_system.service.StudentService;
import kisielw.course_management_system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private AutologinService autologinService;

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/registration")
    public ModelAndView showRegistrationForm() {
        ModelAndView modelAndView = new ModelAndView("registration");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping(path = "/register")
    public String handleNewUser(@ModelAttribute("user") User user) {
        log.info("Handled new user: " + user);

        if (userService.existsByUsername(user.getUsername())) {
            log.info("User with " + user.getUsername() + " already exists.");
            return "registration";
        }

        userService.save(user);
        studentService.save(user);
        autologinService.autologin(user.getUsername());
        return  "redirect:/student/panel";
    }
}
