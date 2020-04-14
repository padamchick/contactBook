package contactbook.application.service;


import contactbook.application.entity.contact.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> findAll();

    Contact findById(int id);

    void save(Contact contact);

    void deleteById(int id);

    List<Contact> searchContacts(String searchName);
}
