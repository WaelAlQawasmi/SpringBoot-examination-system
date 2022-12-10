package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityCofigration extends WebSecurityConfigurerAdapter {
@Autowired
userServiceDetailes userServiceDetailes;
@Bean
public PasswordEncoder getPasswordEncoder(){
//    return NoOpPasswordEncoder.getInstance();
    return new BCryptPasswordEncoder();
}
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userServiceDetailes).passwordEncoder(getPasswordEncoder());

    }


    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.cors().disable().csrf().disable()
                .authorizeRequests()
                .antMatchers("/login", "/signup", "/", "/forgot_password", "/reset_password","/api/**").permitAll() // allow access to login page without Authentication
                .antMatchers("/image/**", "/css/**").permitAll()
                .anyRequest().authenticated() // any other page need  login
                .and()
                .formLogin() // in login form
                .and().rememberMe().and().formLogin()
                .loginPage("/login").permitAll() // the GitMapping rout in controller of login
                .loginProcessingUrl("/login") // the action of login form
                .defaultSuccessUrl("/dashboard",true)
                .failureUrl("/login?error=true")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .deleteCookies("JSESSIONID"); //that we must use
    }
}
