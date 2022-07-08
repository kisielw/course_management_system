package kisielw.course_management_system.controller;

import kisielw.course_management_system.model.User;
import kisielw.course_management_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/registration")
    public String showRegistrationForm(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping(path = "/register")
    public String handleNewUser(@ModelAttribute User user) {
        System.out.println(user);
        userRepository.save(user);
        return "login";
    }
}
