package contactbook.application.controllers;

import contactbook.application.model.Person;
import contactbook.application.services.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private PersonServiceImpl service;

    @GetMapping({"/", "/welcome"})
    public String viewHomePage(Model model) {
        List<Person> listPerson = service.listAll();
        model.addAttribute("listPerson", listPerson);
        return "index";
    }

    @GetMapping("/new")
    public String showNewContactForm(Model model) {
        model.addAttribute("person", new Person());
        return "newcontact";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String savePerson(@ModelAttribute("person") Person person) {
        service.save(person);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPersonForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_person");
        Person person = service.get(id);
        mav.addObject("person", person);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deletePerson(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }




}
