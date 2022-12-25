package com.example.demo.Entity;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
@NonNull
    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;


}