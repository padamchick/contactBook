//package contactbook.application.controller;
//
//import contactbook.application.entity.Credentials;
//import contactbook.application.entity.Person;
////import contactbook.application.services.CredentialsServiceImpl;
//import contactbook.application.services.PersonServiceImpl;
//import contactbook.application.validation.LoginValidator;
//import contactbook.application.validation.RegistrationValidator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
///*
//Obsluga zadan przychodzacych od klienta
// */
//
//@Controller
//public class AppController {
//    @Autowired
//    private PersonServiceImpl personService;
////    @Autowired
////    private CredentialsServiceImpl credentialsService;
//    @Autowired
//    private RegistrationValidator registrationValidator;
//    @Autowired
//    private LoginValidator loginValidator;
//
//    @GetMapping(value={"/","/users"})
//    public String showStartPage(Model model) {
//        List<Person> listPerson = personService.listAll();
//        model.addAttribute("listPerson", listPerson);
//        return "user-list";
//    }
//
//    @GetMapping("/login")
//    public String login() {
//        return "loginPage";
//    }
//
//    @GetMapping("/registration")
//    public String showRegistrationForm(Model model) {
//        model.addAttribute("credentials", new Credentials());
//        return "registration-form";
//    }
//
//    @PostMapping("/registration/save")
//    public String saveCredentials(@Valid @ModelAttribute("credentials") Credentials credentials, BindingResult bindingResult, Model model) {
//        registrationValidator.validate(credentials, bindingResult); //sprawdz dodatkowe warunki (duplikacja loginow/maili, bledne potwierdzenie hasla)
//
//        if(bindingResult.hasErrors()) {
//            return "registration-form";         //powrot do formularza rejestracyjnego, wyswietlenie informacji o nieprawidlowosciach
//        }
//        //jesli wszystko ok, zapisz do bazy
//
//        //credentialsService.save(credentials);
//        model.addAttribute("registrationSucceeded", "Registration succeeded!");
//        return "loginPage";
//    }
//
//    @GetMapping("/users/new")                           //otworz strone z formularzem nowego kontaktu
//    public String showNewContactForm(Model model) {
//        model.addAttribute("person", new Person());
//        return "contact-form";
//    }
//
//    @PostMapping("/users/save")  //zapisz nowy/edytowany kontakt
//    public String saveContact(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//                return "contact-form";
//        }
//        personService.save(person);
//        return "redirect:/users/";          //zapisz i powrot do strony glownej
//    }
//
//    @GetMapping("/users/edit")
//    public String showEditPersonForm(@RequestParam("personId") Long id, Model model) {
//        Person person = personService.get(id);
//        model.addAttribute("person", person);
//        return "contact-form";
//    }
//
//    @GetMapping("/users/contact")
//    public String showContact(@RequestParam("personId") Long id, Model model) {
//        Person person = personService.get(id);
//        model.addAttribute("person", person);
//        return "showContact";
//    }
//
//    @GetMapping("/users/delete")
//    public String deletePerson(@RequestParam("personId") Long id) {
//        personService.delete(id);
//        return "redirect:/users/";
//    }
//
//
//
//
//}
