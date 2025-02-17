package com.pablo.user_service.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@Setter
@Getter
@Entity
@Table(name = "_user")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Getter
    private String email;

    private String firstName;

    private String lastName;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    //Using email as username
    public String getUsername() {return this.email;}

    @Override
    public String getPassword(){return this.password;}

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
        //TODO implement expired account logic
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
        //TODO implement locked accounnts logic
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
        //TODO implements expired credentials logic
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
        //TODO implement enable and disbling accounts logic
    }
}
