//package contactbook.application.services;
//
//import contactbook.application.entity.Person;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//import java.util.List;
//
//@Service
//public class PersonServiceImpl implements PersonService {
//    @Autowired
//    private PersonRepository repo;
//
//    public List<Person> listAll() {     //wyswietl w kolejnosci alfabetycznej
//        List<Person> list = repo.findAll();
//        Collections.sort(list, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
//        return list;
//    }
//
//    public void save(Person person) {
//        repo.save(person);
//    }
//
//    public Person get(Long id) {
//        return repo.findById(id).get();
//    }
//
//    public void delete(Long id) {
//        repo.deleteById(id);
//    }
//
//}
