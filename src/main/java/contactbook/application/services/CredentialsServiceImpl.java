//package contactbook.application.services;
//
//import contactbook.application.model.Credentials;
//import contactbook.application.repositories.CredentialsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CredentialsServiceImpl implements CredentialsService {
//
//    @Autowired
//    private CredentialsRepository repo;
//
//    @Autowired
//    private PasswordEncoder bCryptPasswordEncoder;
//
//    public List<Credentials> listAll() {
//        return repo.findAll(); }
//
//    public void save(Credentials credentials) {
//        credentials.setPassword(bCryptPasswordEncoder.encode(credentials.getPassword()));   //szyfrowanie hasla
//        repo.save(credentials);
//    }
//
//    public Credentials get(Long id) {
//        return repo.findById(id).get();
//    }
//
//    public void delete(Long id) {
//        repo.deleteById(id);
//    }
//
//    @Override
//    public Credentials findByEmail(String email) {      //znajdz uzytkownika po mailu
//        List<Credentials> tempList = listAll();
//        for(Credentials match:tempList) {
//            if(match.getEmail().equals(email))
//                return match;
//        }
//        return null;
//    }
//
//    @Override
//    public Credentials findByUsername(String username) {
//        List<Credentials> tempList = listAll();
//        for(Credentials match:tempList) {
//            if(match.getUsername().equals(username))
//                return match;
//        }
//        return null;
//    }
//
//
//
//
//}
