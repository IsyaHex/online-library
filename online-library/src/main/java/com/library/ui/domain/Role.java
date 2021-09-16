package com.library.ui.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ui_users_roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "role_seq")
    @SequenceGenerator(name = "role_seq", sequenceName = "seq_ui_users_roles", allocationSize = 1)
    private Long id;

    @Column(name = "role_name")
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return id.equals(role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
