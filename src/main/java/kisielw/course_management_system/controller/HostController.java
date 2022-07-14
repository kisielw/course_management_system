package kisielw.course_management_system.controller;

import kisielw.course_management_system.model.Host;
import kisielw.course_management_system.model.Role;
import kisielw.course_management_system.model.User;
import kisielw.course_management_system.repository.HostRepository;
import kisielw.course_management_system.repository.UserRepository;
import kisielw.course_management_system.service.HostService;
import kisielw.course_management_system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;

@Controller
@Slf4j
public class HostController {

    @Autowired
    private HostService hostService;

    @Autowired
    private UserService userService;

    @GetMapping(path = "/admin/hosts")
    public String showAllHosts(ModelMap modelMap) {
        modelMap.addAttribute("hosts", hostService.findAll());
        return "host_list";
    }

    @GetMapping(path = "/admin/add_host")
    public String showFormToAddNewHost(ModelMap modelMap) {
        modelMap.addAttribute("emptyUser", new User());
        return "add_host";
    }

    @PostMapping(path = "/admin/save_host")
    public String handleNewHost(@ModelAttribute("emptyUser") User user) {
        log.info("Handle new user" + user);
        userService.save(user, "HOST");
        hostService.save(user);
        return "redirect:/admin/hosts";
    }
}
