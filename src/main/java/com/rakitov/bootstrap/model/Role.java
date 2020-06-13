package com.rakitov.bootstrap.model;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@Getter
@Setter
public class Role implements GrantedAuthority {

    public Role() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Transient
    @ManyToMany(mappedBy = "role")
    private Set<User> userSet;

    @Override
    public String toString() {
        String role = "";
        if (this.id == 1L) {
            role = "ADMIN";
        }
        if (this.id == 2L) {
            role = "USER";
        }
        return role;
    }

    @Override
    public String getAuthority() {
        return getName();
    }

}
