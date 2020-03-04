package contactbook.application.controller;

import contactbook.application.entity.Contact;
import contactbook.application.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
