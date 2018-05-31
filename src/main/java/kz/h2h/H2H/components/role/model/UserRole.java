package kz.h2h.H2H.components.role.model;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name="user_roles")
public class UserRole {
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String description;

    public static final String roleAdmin = "admin";
    public static final String roleModerator = "moderator";

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
