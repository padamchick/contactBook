package contactbook.application.service;

import contactbook.application.entity.contact.Contact;
import contactbook.application.entity.user.User;
import contactbook.application.user.NewUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);
    void save(NewUser newUser);
    void save(User user);
    List<User> findAll();
    User findById(int id);
    void deleteById(int id);

    List<User> searchUsers(String searchName);
}
