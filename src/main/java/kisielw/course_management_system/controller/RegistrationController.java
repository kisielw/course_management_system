package kisielw.course_management_system.controller;

import kisielw.course_management_system.model.User;
import kisielw.course_management_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/registration")
    public ModelAndView showRegistrationForm() {
        ModelAndView modelAndView = new ModelAndView("registration");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping(path = "/register")
    public String handleNewUser(@ModelAttribute("user") User user) {
        System.out.println(user);
        userRepository.save(user);
        return "login";
    }
}
