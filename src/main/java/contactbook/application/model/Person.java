package contactbook.application.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "This field is required.")
    @Size(min=1, message = "This field is required.")
    @Column(name="first_name")
    private String firstName;

    @NotNull(message = "This field is required.")
    @Size(min=1, message = "This field is required.")
    @Column(name="last_name")
    private String lastName;

    @NotNull(message = "This field is required.")
    @Size(min=1, message = "This field is required.")
    private String email;

    private String category;

    @NotNull(message = "This field is required.")
    @Size(min=1, message = "This field is required.")
    @Column(name="birth_date")
    @Pattern(regexp = "[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}", message = "Invalid date format.")
    private String birthDate;

    @NotNull(message = "This field is required.")
    @Size(min=1, message = "This field is required.")
    @Column(name="phone_number")
    @Size(min=9, message = "The number requires 9 digits.")
    private String phoneNumber;

    public Person() {
    }

    public Person(String firstName, String lastName, String email) {
        super();
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
