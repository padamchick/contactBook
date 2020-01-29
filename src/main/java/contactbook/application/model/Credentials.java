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

    @NotNull(message = "This field is required.")
    @Size(min=1, message = "This field is required.")
    @Pattern(regexp = ".+@.+\\..+", message = "Incorrect mail format. Should be sth@sth.sth")
    @Column(name = "email")
    private String email;

    @NotNull(message = "This field is required.")
    @Size(min=6, message = "Please use more than 6 characters.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}$", message = "Password requires" +
            " a lower and an upper case letter and a digit.")
    @Column(name = "password")
    private String password;

    @NotNull(message = "This field is required.")
    @Column(name = "conf_password")
    private String confPassword;

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

    public String getConfPassword() {
        return confPassword;
    }

    public void setConfPassword(String confPassword) {
        this.confPassword = confPassword;
    }
}
