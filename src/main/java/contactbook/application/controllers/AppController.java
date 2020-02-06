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

/*
Obsluga zadan przychodzacych od klienta
 */

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

    @GetMapping(value={"/","/users"})
    public String showStartPage(Model model) {
        List<Person> listPerson = personService.listAll();
        model.addAttribute("listPerson", listPerson);
        return "usersPage";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");      //informacje o errorach i logoutach wyswietlane w pliku login.jsp

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        model.addAttribute("credentials", new Credentials());
        return "loginPage";
    }

    @RequestMapping(value = "/logintopage", method = RequestMethod.POST)
    public String login(@Valid @ModelAttribute("credentials") Credentials credentials, BindingResult bindingResult) {
        loginValidator.validate(credentials, bindingResult);    //sprawdz, czy
        if(bindingResult.hasErrors()) {
            return "loginPage";
        }
        return "redirect:/users";
    }

    @RequestMapping(value = "/logout")          //wyloguj
    public String logout() {
        return "redirect:/login";
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("credentials", new Credentials());
        return "registration-form";
    }

    @RequestMapping(value = "/registration/save", method = RequestMethod.POST)
    public String saveCredentials(@Valid @ModelAttribute("credentials") Credentials credentials, BindingResult bindingResult) {
        registrationValidator.validate(credentials, bindingResult); //sprawdz dodatkowe warunki (duplikacja loginow/maili, bledne potwierdzenie hasla)

        if(bindingResult.hasErrors()) {
            return "registration-form";         //powrot do formularza rejestracyjnego, wyswietlenie informacji o nieprawidlowosciach
        }
        credentialsService.save(credentials);   //jesli wszystko ok, zapisz do bazy
        return "redirect:/login";
    }

    @GetMapping("/users/new")                           //otworz strone z formularzem nowego kontaktu
    public String showNewContactForm(Model model) {
        model.addAttribute("person", new Person());
        return "newcontact";
    }

    @RequestMapping(value = "users/save", method = RequestMethod.POST)  //zapisz nowy/edytowany kontakt
    public String savePerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            if(person.getId()==null) {      //jesli blad z formularza dla nowego kontaktu
                return "newcontact";
            } else {                        //jesli blad z formularza dla edytowanego kontaktu
                return "redirect:/users/edit/"+person.getId();
            }

        }
        personService.save(person);
        return "redirect:/users/";          //zapisz i powrot do strony glownej
    }

    @RequestMapping("/users/edit/{id}")
    public ModelAndView showEditPersonForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_person");
        Person person = personService.get(id);
        mav.addObject("person", person);
        return mav;
    }

    @RequestMapping("/users/showcontact/{id}")
    public ModelAndView showSelectedContact(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("showContact");
        Person person = personService.get(id);
        mav.addObject("person", person);
        return mav;
    }

    @RequestMapping("/users/delete/{id}")
    public String deletePerson(@PathVariable(name = "id") Long id) {
        personService.delete(id);
        return "redirect:/users/";
    }




}
