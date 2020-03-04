package contactbook.application.entity.contact;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @Column(name = "birth_date")
    private String birthDay;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String category;
}
