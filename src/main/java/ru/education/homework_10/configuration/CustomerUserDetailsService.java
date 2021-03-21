package ru.education.homework_10.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.education.homework_10.models.entity.Customer;
import ru.education.homework_10.services.CustomerService;

@Component
public class CustomerUserDetailsService implements UserDetailsService {
    @Autowired
    private CustomerService service;

    @Override
    public CustomerUserDetails loadUserByUsername(String userLogin) throws UsernameNotFoundException {
        Customer c = service.findCustomer(userLogin);
        return CustomerUserDetails.fromCustomerEntityToUserDetails(c);
    }
}
