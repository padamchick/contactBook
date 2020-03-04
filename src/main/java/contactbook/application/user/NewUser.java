package contactbook.application.user;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class NewUser {
    @NotNull(message = "This field is required.")
    @Size(min=1, message = "This field is required.")
    private String username;

    @NotNull(message = "This field is required.")
    @Size(min=1, message = "This field is required.")
    private String firstName;

    @NotNull(message = "This field is required.")
    @Size(min=1, message = "This field is required.")
    private String lastName;

    @NotNull(message = "This field is required.")
    @Size(min=1, message = "This field is required.")
    @Pattern(regexp = ".+@.+\\..+", message = "Invalid mail format")
    private String email;

    @NotNull(message = "This field is required.")
    @Size(min=6, message = "Please use more than 6 characters.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}$", message = "Password requires" +
            " a lower and an upper case letter and a digit.")
    private String password;

    @NotNull(message = "This field is required.")
    private String confPassword;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
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
