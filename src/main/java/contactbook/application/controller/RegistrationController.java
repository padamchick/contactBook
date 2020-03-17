package contactbook.application.controller;

import contactbook.application.entity.user.User;
import contactbook.application.service.SecurityService;
import contactbook.application.service.UserService;
import contactbook.application.user.NewUser;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private UserService userService;
    private SecurityService securityService;

    public RegistrationController(UserService userService, SecurityService securityService) {
        this.userService = userService;
        this.securityService = securityService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showRegistrationForm")
    public String showRegistrationForm(Model model) {
        model.addAttribute("newUser", new NewUser());
        return "registration-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("newUser") NewUser newUser,
            BindingResult bindingResult,
            Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("newUser", newUser);
            return "registration-form";
        }
        User existing = userService.findByUserName(newUser.getUsername());
        if (existing!=null) {
            model.addAttribute("newUser", new NewUser());
            model.addAttribute("registrationError", "Username already existis");

            return "registration-form";
        }

        userService.save(newUser);
        securityService.autoLogin(newUser.getUsername(), newUser.getPassword());
//        model.addAttribute("registrationSucceeded", "Registration succeeded!");
//        return "login-page";
        return "redirect:/contacts/list";

    }
}
