package com.example.copsboot.user;

import com.example.orm.jpa.AbstractEntity;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "copsboot_user")
public class User extends AbstractEntity<UserId> {
    @Id
    private UserId id;
    private String email;
    private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Set<UserRole> roles;

    protected User() {
    }

    public User(UserId id, String email, String password, Set<UserRole> roles) {
        super(id);
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}