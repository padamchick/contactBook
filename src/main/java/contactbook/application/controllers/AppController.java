package contactbook.application.controllers;

import contactbook.application.model.Credentials;
import contactbook.application.model.Person;
import contactbook.application.services.CredentialsServiceImpl;
import contactbook.application.services.PersonServiceImpl;
import contactbook.application.validation.LoginValidator;
import contactbook.application.validation.RegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AppController {
    @Autowired
    private PersonServiceImpl personService;
    @Autowired
    private CredentialsServiceImpl credentialsService;
    @Autowired
    private RegistrationValidator registrationValidator;
    @Autowired
    private LoginValidator loginValidator;

    @GetMapping("/")
    public String login(Model model) {
        model.addAttribute("credentials", new Credentials());
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("credentials") Credentials credentials, BindingResult bindingResult) {
        loginValidator.validate(credentials, bindingResult);
        if(bindingResult.hasErrors()) {
            return "index";
        }

        return "redirect:/welcome";
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("credentials", new Credentials());
        return "registration-form";
    }

    @RequestMapping(value = "/registration/save", method = RequestMethod.POST)
    public String saveCredentials(@Valid @ModelAttribute("credentials") Credentials credentials, BindingResult bindingResult) {
        registrationValidator.validate(credentials, bindingResult);

        if(bindingResult.hasErrors()) {
            return "registration-form";
        }
        credentialsService.save(credentials);
        return "redirect:/";
    }

    @GetMapping("/welcome")
    public String viewWelcomePage(Model model) {
        List<Person> listPerson = personService.listAll();
        model.addAttribute("listPerson", listPerson);
        return "users";
    }

    @GetMapping("/welcome/new")
    public String showNewContactForm(Model model) {
        model.addAttribute("person", new Person());
        return "newcontact";
    }

    @RequestMapping(value = "welcome/save", method = RequestMethod.POST)
    public String savePerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {
        personService.save(person);
        return "redirect:/welcome/";
    }

    @RequestMapping("/welcome/edit/{id}")
    public ModelAndView showEditPersonForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_person");
        Person person = personService.get(id);
        mav.addObject("person", person);
        return mav;
    }

    @RequestMapping("/welcome/showcontact/{id}")
    public ModelAndView showSelectedContact(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("showContact");
        Person person = personService.get(id);
        mav.addObject("person", person);
        return mav;
    }

    @RequestMapping("/welcome/delete/{id}")
    public String deletePerson(@PathVariable(name = "id") Long id) {
        personService.delete(id);
        return "redirect:/welcome/";
    }


}
