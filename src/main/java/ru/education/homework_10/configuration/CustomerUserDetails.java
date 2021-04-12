package ru.education.homework_10.configuration;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.education.homework_10.models.entity.Customer;

import java.util.Collection;
import java.util.Collections;


public class CustomerUserDetails implements UserDetails {
    private String login;
    private String password;
    private Collection<? extends GrantedAuthority> grantedAuthorities;

    public static CustomerUserDetails fromCustomerEntityToUserDetails(Customer customer){
        CustomerUserDetails c = new CustomerUserDetails();
        c.login=customer.getName();
        c.password=customer.getPassword();
        c.grantedAuthorities= Collections.singletonList( new SimpleGrantedAuthority(customer.getRole().getName()));
        return c;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
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
