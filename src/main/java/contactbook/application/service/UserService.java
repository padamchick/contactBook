package contactbook.application.service;

import contactbook.application.entity.user.User;
import contactbook.application.user.NewUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public User findByUserName(String userName);

    public void save(NewUser newUser);
}
