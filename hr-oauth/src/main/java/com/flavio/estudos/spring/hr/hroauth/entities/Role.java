package com.flavio.estudos.spring.hr.hroauth.entities;

import java.io.Serializable;

public class Role implements Serializable {

    private Long id;
    private String roleName;

    public Role() {
    }

    public Role(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }
}
