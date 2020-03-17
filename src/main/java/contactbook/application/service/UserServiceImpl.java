package contactbook.application.service;

import contactbook.application.entity.contact.Contact;
import contactbook.application.entity.user.Role;
import contactbook.application.entity.user.User;
import contactbook.application.repository.user.RoleRepository;
import contactbook.application.repository.user.UserRepository;
import contactbook.application.user.NewUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository=userRepository;
        this.roleRepository=roleRepository;
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public void save(NewUser newUser) {
        User user = new User();
//        przypisz dane uzytkownika do nowego obiektu uzytkownik
        user.setUserName(newUser.getUsername());
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setEmail(newUser.getEmail());

//        nadaj uzytkownikowi domyslnie role EMPLOYEE
        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));

//        zapisz do bazy danych
        userRepository.save(user);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public User findById(int id) {
        Optional<User> result = userRepository.findById(id);
        User user = null;
        if(result.isPresent()) {
            user = result.get();
        }
        return user;
    }

    @Override
    public void deleteById(int id) {
        User user = findById(id);
        user.removeAllRoles();
        userRepository.save(user);
        userRepository.deleteById(id);
    }

    @Override
    public List<User> searchUsers(String searchName) {
        List<User> results = null;

        if(searchName!=null && searchName.trim().length()>0) {
            results = userRepository.
                    findByFirstNameContainsOrLastNameContainsAllIgnoreCase(searchName, searchName);
        } else {
            results = findAll();
        }
        return results;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user == null ) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
