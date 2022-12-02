package com.example.demo.Entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Setter// use to create setter for all attribute
@Getter// use to create getter for all attribute
@NoArgsConstructor // to create deflate constructor ( constactor with out any args)
@RequiredArgsConstructor// to create constactor with arg that have  @NonNull
@Entity // to crate table for this class
public class users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @Column(unique=true)
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String email;
    @NonNull
    private String name;

    @NonNull
    private String sex;

    @NonNull
    private String role; // the role name

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return  Arrays.asList(new SimpleGrantedAuthority(role)); // to return the role Authority
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // you can create Properties to change this
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
