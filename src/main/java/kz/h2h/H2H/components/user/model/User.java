package kz.h2h.H2H.components.user.model;


import kz.h2h.H2H.components.role.model.UserRole;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String surname;
    @NonNull
    private String number;
    private String address;
    @NonNull
    private String gender;

    @NonNull
    private String password;

    @NonNull
    private String email;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
            name = "user_role_links",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<UserRole> roles;

}
