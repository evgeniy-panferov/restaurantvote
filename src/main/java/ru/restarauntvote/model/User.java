package ru.restarauntvote.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    Set<Role> roles;

    private String email;

    public User(int id, String email) {
        super(id);
        this.email = email;
    }

    public User(){

    }


}
