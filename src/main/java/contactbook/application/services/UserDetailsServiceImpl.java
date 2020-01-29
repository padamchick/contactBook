//package contactbook.application.services;
//
//import contactbook.application.model.Credentials;
//import contactbook.application.repositories.CredentialsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.HashSet;
//import java.util.Set;
//
//@Service
//    public class UserDetailsServiceImpl implements UserDetailsService{
//        @Autowired
//        private CredentialsRepository repository;
//
//        @Override
//        @Transactional
//        public UserDetails loadUserByUsername(String username) {
//            Credentials user = repository.findByUsername(username);
//            if (user == null) throw new UsernameNotFoundException(username);
//
//            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//            for (Role role : user.getRoles()){
//                grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
//            }
//
//            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.);
//        }
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Credentials user = repository.findByUsername(username);
//        if (user==null) throw new UsernameNotFoundException(username);
//
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getEmail());
//    }
//}
