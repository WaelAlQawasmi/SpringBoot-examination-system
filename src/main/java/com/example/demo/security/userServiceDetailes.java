package com.example.demo.security;

import ch.qos.logback.classic.Logger;
import com.example.demo.Entity.Privilege;
import com.example.demo.Entity.Role;
import com.example.demo.Entity.user;
import com.example.demo.Repositories.userRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class userServiceDetailes implements UserDetailsService {
    private final Logger LOG = (Logger) LoggerFactory.getLogger(userServiceDetailes.class);

    @Autowired
    userRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

         user user= userRepository.findByemail(username);

        if(user == null){
            LOG.info("******************************");
            throw new UsernameNotFoundException("User not authorized.");
        }
        LOG.info(">>>>>>>>>>>>"+user.getUsername());

        return user;
    }


    private Collection<? extends GrantedAuthority> getAuthorities(
            Collection<Role> roles) {

        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<String> getPrivileges(Collection<Role> roles) {

        List<String> privileges = new ArrayList<>();
        List<Privilege> collection = new ArrayList<>();
        for (Role role : roles) {
            privileges.add(role.getName());
            collection.addAll(role.getPrivileges());
        }
        for (Privilege item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }
}
