package kisielw.course_management_system.controller;

import kisielw.course_management_system.repository.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HostController {

    @Autowired
    private HostRepository hostRepository;

    @GetMapping(path = "/admin/hosts")
    public String showAllHosts(ModelMap modelMap) {
        modelMap.addAttribute("hosts", hostRepository.findAll());
        return "host_list";
    }
}
