package contactbook.application.services;

import contactbook.application.model.Person;

import java.util.List;

public interface PersonService {
    void save(Person person);
    List<Person> listAll();
    Person get(Long id);
    void delete(Long id);
    Person findByEmail(String email);
}
