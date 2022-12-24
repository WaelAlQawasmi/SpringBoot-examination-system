package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class users implements UserDetails {

    @Setter(value = AccessLevel.NONE)
    @Id
    @GeneratedValue

    Long id;
    @NonNull
    String name;
    @NonNull
    String email;
    @NonNull
    String password;


    Boolean isAccountNonExpired;


    @OneToMany(mappedBy="user")
    private List<exams> exams;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
