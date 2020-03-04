package contactbook.application.controller;

import contactbook.application.entity.Contact;
import contactbook.application.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    private ContactService contactService;

    public ContactController(ContactService theContactService) {
        contactService = theContactService;
    }

    @GetMapping("/list")
    public String showContactList(Model model) {
        List<Contact> contactList = contactService.findAll();
        model.addAttribute("contactList", contactList);
        return "contacts/contact-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        model.addAttribute("contact", new Contact());
        return "contacts/contact-form";
    }

    @PostMapping("/save")
    public String saveContact(@ModelAttribute("contact") Contact contact) {
        contactService.save(contact);
        return "redirect:/contacts/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("contactId") int id, Model model) {
        Contact contact = contactService.findById(id);
        model.addAttribute("contact", contact);
        return "contacts/contact-form";
    }

    @GetMapping("/delete")
    public String deleteContact(@RequestParam("contactId") int id) {
        contactService.deleteById(id);
        return "redirect:/contacts/list";
    }

    @GetMapping("/search")
    public String searchContacts(@RequestParam("searchName") String searchName, Model model) {
        List<Contact> contactList = contactService.searchContacts(searchName);
        model.addAttribute("contactList", contactList);
        model.addAttribute("searchName", searchName);
        return "contacts/contact-list";
    }

}
