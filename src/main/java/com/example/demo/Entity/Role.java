package com.example.demo.Entity;

import lombok.*;
import javax.persistence.*;
import java.util.Collection;

@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
@NonNull
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<user> users;

    @ManyToMany
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;
}