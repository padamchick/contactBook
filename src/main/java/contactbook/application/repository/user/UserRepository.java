package contactbook.application.repository.user;

import contactbook.application.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String username);
    List<User> findAllByOrderByLastNameAsc();
}
