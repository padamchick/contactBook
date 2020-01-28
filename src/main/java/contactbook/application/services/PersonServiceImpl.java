package contactbook.application.services;

import contactbook.application.model.Person;
import contactbook.application.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository repo;

    public List<Person> listAll() { return repo.findAll(); }

    public void save(Person person) {
        repo.save(person);
    }

    public Person get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Person findByEmail(String email) {
        return repo.findByEmail(email);
    }
}
