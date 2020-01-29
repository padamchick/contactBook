package contactbook.application.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="credentials")
public class Credentials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "required")
    @Size(min=1, message = "required")
    @Pattern(regexp = ".+@.+\\..+", message = "incorrect email format")
    @Column(name = "email")
    private String email;

    @NotNull(message = "required")
    @Size(min=6, message = "min 6 signs required")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}$", message = "password requires" +
            " a lower and an upper case letter and digit ")
    @Column(name = "password")
    private String password;

    public Credentials() {
    }

    public Credentials(String email, String password) {
        super();
        this.email=email;
        this.password=password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
