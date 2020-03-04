package contactbook.application.repository.contact;

import contactbook.application.entity.contact.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    List<Contact> findAllByOrderByLastNameAsc();
    List<Contact> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String fName, String lName);
}
