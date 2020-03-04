package contactbook.application.service;

import contactbook.application.entity.contact.Contact;
import contactbook.application.repository.contact.ContactRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository theContactRepository) {
        contactRepository = theContactRepository;
    }

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Contact findById(int id) {
        Optional<Contact> result = contactRepository.findById(id);

        Contact contact = null;

        if(result.isPresent()) {
            contact=result.get();
        } else {
            throw new RuntimeException("Didn't find contact with id = "+id);
        }

        return contact;
    }

    @Override
    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void deleteById(int id) {
        contactRepository.deleteById(id);
    }

    @Override
    public List<Contact> searchContacts(String searchName) {

        List<Contact> results = null;

        if(searchName!=null && searchName.trim().length()>0) {
            results = contactRepository.
                    findByFirstNameContainsOrLastNameContainsAllIgnoreCase(searchName, searchName);
        } else {
            results = findAll();
        }
        return results;
    }
}
