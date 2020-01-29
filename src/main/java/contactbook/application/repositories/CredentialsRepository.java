package contactbook.application.repositories;

import contactbook.application.model.Credentials;
import contactbook.application.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialsRepository extends JpaRepository<Credentials, Long> {
    Credentials findByUsername(String username);
}
