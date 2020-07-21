package ru.restarauntvote.model;

import org.hibernate.annotations.BatchSize;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role"}, name = "user_roles_unique_idx")})
    @ElementCollection(fetch = FetchType.EAGER)
    @BatchSize(size = 200)
    Set<Role> roles;

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotBlank
    @Size(max = 100)
    private String email;

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    public User(User u) {
        this(u.getId(), u.getEmail(), u.getName(), u.getRoles());
    }

    public User(int id, String email, String name, Role role, Role... roles) {
        this(id, email, name, EnumSet.of(role, roles));
    }

    public User(int id, String email, String name, Collection<Role> roles) {
        super(id);
        this.email = email;
        this.name = name;
        setRoles(roles);
    }

    public User() {

    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = CollectionUtils.isEmpty(roles) ? EnumSet.noneOf(Role.class) : EnumSet.copyOf(roles);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
