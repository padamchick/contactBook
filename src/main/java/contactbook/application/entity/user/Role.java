package contactbook.application.entity.user;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Setter @Getter
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        switch (name) {
            case "ROLE_USER":
                return "USER";
            case "ROLE_MODERATOR":
                return "MODERATOR";
            case "ROLE_ADMIN":
                return "ADMIN";
            default:
                return "NONE";
        }

    }
}
