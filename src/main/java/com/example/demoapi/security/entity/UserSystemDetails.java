package com.example.demoapi.security.entity;

import com.example.demoapi.entity.UserSystem;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@Builder
public class UserSystemDetails implements UserDetails {

    private UserSystem userSystem;

    public UserSystemDetails(UserSystem userSystem) {
        this.userSystem = userSystem;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userSystem.getRoles();
    }

    @Override
    public String getPassword() {
        return userSystem.getPassword();
    }

    @Override
    public String getUsername() {
        return userSystem.getEmail();
    }

    @Override
    public boolean isEnabled() {
        return userSystem.isEnabled();
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
}
