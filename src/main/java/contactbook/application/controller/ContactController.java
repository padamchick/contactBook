package contactbook.application.controller;

import contactbook.application.entity.Contact;
import contactbook.application.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
