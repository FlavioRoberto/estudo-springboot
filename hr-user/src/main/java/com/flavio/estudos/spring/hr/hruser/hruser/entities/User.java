package com.flavio.estudos.spring.hr.hruser.hruser.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String Password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        Password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Column(unique = true)
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return Password;
    }

    public Set<Role> getRoles() {
        return roles;
    }
}
