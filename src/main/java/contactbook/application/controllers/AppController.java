package contactbook.application.controllers;

import contactbook.application.model.Credentials;
import contactbook.application.model.Person;
import contactbook.application.services.CredentialsServiceImpl;
import contactbook.application.services.PersonServiceImpl;
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

    @GetMapping("/")
    public String login(Model model) {
        model.addAttribute("credentials", new Credentials());
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("credentials") Credentials credentials) {
        Credentials user = credentialsService.findByEmail(credentials.getEmail());
        if (user == null) {
            return "index-error";
        } else if (!user.getPassword().equals(credentials.getPassword())) {
            return "index-password-error";
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
        if(bindingResult.hasErrors()) {
            return "registration-form";
        }
        System.out.println(credentialsService.isRegistered(credentials.getEmail()));
        if (credentialsService.isRegistered(credentials.getEmail()))
            return "registration-form-error";
        credentialsService.save(credentials);
        return "redirect:/";
    }

    @GetMapping("/welcome")
    public String viewWelcomePage(Model model) {
        List<Person> listPerson = personService.listAll();
        model.addAttribute("listPerson", listPerson);
        return "/welcome";
    }

    @GetMapping("/welcome/new")
    public String showNewContactForm(Model model) {
        model.addAttribute("person", new Person());
        return "newcontact";
    }

    @RequestMapping(value = "welcome/save", method = RequestMethod.POST)
    public String savePerson(@ModelAttribute("person") Person person) {
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

    @RequestMapping("/welcome/delete/{id}")
    public String deletePerson(@PathVariable(name = "id") Long id) {
        personService.delete(id);
        return "redirect:/welcome/";
    }


}
