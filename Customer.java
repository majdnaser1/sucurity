package com.example.finalprojecbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Customer implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition ="varchar(20) not null")
    private String name;
    @Column(columnDefinition ="varchar(20) unique not null")
    private String username;
    @Column(columnDefinition ="varchar(255) not null")
    private String password;
    @Column(columnDefinition ="varchar(10) unique not null")
    //@Size(min = 10,max = 10 ,message = "Phone number must be 10 characters")
//    @Pattern(regexp = "^(05)([0-9])$",message = "please enter right phone number")
    private String phoneNumber;
    @Pattern(regexp = "(customer)",message = "Role must be in customer only")
    private String role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.role));
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

