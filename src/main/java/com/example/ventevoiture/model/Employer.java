package com.example.ventevoiture.model;


import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


// raha tiany tsy ho colonne anaty base ny attribut de class dia asina annotation @Transient


@Entity(name = "employer")
@Table(name = "employer")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employer implements UserDetails{
    
    @jakarta.persistence.Id
    @SequenceGenerator(
        name = "employer_sequence",
        sequenceName = "employer_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "employer_sequence"
    )
    @Column(name = "id", updatable = false)
    Long id;

    String firstname;
    String lastname;
    String email;
    String password;
    

    @Enumerated(EnumType.STRING)
    Role role;
    
   
    
   
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }
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
