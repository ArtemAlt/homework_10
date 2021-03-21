package ru.education.homework_10.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.education.homework_10.models.DTO.AddCustomerDTO;
import ru.education.homework_10.models.entity.Role;
import ru.education.homework_10.repository.CustomerRepository;
import ru.education.homework_10.models.entity.Customer;
import ru.education.homework_10.repository.RoleRepository;

import java.util.Collection;
@Slf4j
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder encoder;

    public Customer findCustomer(String customer) {
        return repository.findByName(customer);
    }

    public Customer saveCustomer(AddCustomerDTO dto)  {
        Customer customer = new Customer();
        Role role = null;
        try {
            role = roleRepository.findById(dto.getRole()).orElseThrow(()->new NoSuchFieldException("No such role - "+dto.getRole()));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        assert role != null;
        log.info("New customer role in -"+role.getName());
        customer.setRole(role);
        log.info("New customer role out -"+customer.getRole().getName());
        customer.setPassword(encoder.encode(dto.getPassword()));
        log.info("New customer pass - "+customer.getPassword());
        customer.setName(dto.getName());
        log.info("New customer name - "+customer.getName());
        return repository.saveAndFlush(customer);
    }

    public Customer findByLoginAndPassword(String login, String password){
        Customer c = repository.findByName(login);
        if (c != null ) {
           if (encoder.matches(password,c.getPassword())){
               return c;
           }
        }
        return null;
    }


}
