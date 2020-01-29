package contactbook.application.services;

import contactbook.application.model.Credentials;
import contactbook.application.repositories.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialsServiceImpl implements CredentialsService {

    @Autowired
    private CredentialsRepository repo;

    public List<Credentials> listAll() { return repo.findAll(); }

    public void save(Credentials credentials) {
        repo.save(credentials);
    }

    public Credentials get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Credentials findByEmail(String email) {
        List<Credentials> tempList = listAll();
        for(Credentials match:tempList) {
            if(match.getEmail().equals(email))
                return match;
        }
        return null;
    }

    @Override
    public boolean isRegistered(String email) {
        List<Credentials> tempList = listAll();
        for(Credentials match:tempList) {
            if(match.getEmail().equals(email))
                return true;
        }
        return false;
    }

}
