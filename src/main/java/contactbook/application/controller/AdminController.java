package contactbook.application.controller;

import contactbook.application.entity.contact.Contact;
import contactbook.application.entity.user.User;
import contactbook.application.repository.user.RoleRepository;
import contactbook.application.service.RoleService;
import contactbook.application.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/panel")
    public String getAdminPanel(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users/user-list";
    }

    @GetMapping("/panel/editUser")
    public String editUser(@RequestParam("userId") int userId, Model model) {
        User user = userService.findById(userId);
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.findAll());
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

    @GetMapping("/panel/search")
    public String searchContacts(@RequestParam("searchName") String searchName, Model model) {
        List<User> users = userService.searchUsers(searchName);
        model.addAttribute("users", users);
        model.addAttribute("searchName", searchName);
        return "users/user-list";
    }

}
