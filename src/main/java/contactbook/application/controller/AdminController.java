package contactbook.application.controller;

import contactbook.application.entity.user.User;
import contactbook.application.repository.user.RoleRepository;
import contactbook.application.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private RoleRepository roleRepository;

    public AdminController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/panel")
    public String getAdminPanel(Model model) {
        List<User> users = userService.findAllByOrderByLastNameAsc();
        model.addAttribute("users", users);
        return "users/user-list";
    }

    @GetMapping("/panel/editUser")
    public String editUser(@RequestParam("userId") int userId, Model model) {
        User user = userService.findById(userId);
        model.addAttribute("user", user);
        model.addAttribute("roles", roleRepository.findAll());
        return "users/user-form";
    }

    @PostMapping("/panel/saveUser")
    public String save(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin/panel";
    }

    @GetMapping("/panel/delete")
    public String deleteContact(@RequestParam("userId") int id) {
        userService.deleteById(id);
        return "redirect:/admin/panel";
    }

}
