package com.bookstoreproject.bookstore.configSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
//                .requestMatchers("/user").hasAnyRole("ADMIN")               // ######## role base authentication #######
                .requestMatchers("/**").permitAll()                                   // ######## permit all requests #######
//                .requestMatchers("/book/").hasAnyRole("USER")
//                .requestMatchers("/author").hasAnyRole("AUTHOR")
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement(session -> session.maximumSessions(2))
                .httpBasic();
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        // creating users to provide role for role base authentication and providing custom password

        UserDetails user = User
                                .withUsername("user")
                                .password(passwordEncoder().encode("userPass"))
                                .roles("USER")
                                .build();
        UserDetails author = User
                                .withUsername("author")
                                .password(passwordEncoder().encode("authorPass"))
                                .roles("AUTHOR")
                                .build();
        UserDetails admin = User
                                .withUsername("admin")
                                .password(passwordEncoder().encode("adminPass"))
                                .roles("ADMIN")
                                .build();
        return new InMemoryUserDetailsManager(user, author, admin);
    }


    //this password encoder is mandatory for using spring security in spring 3+ version
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}




