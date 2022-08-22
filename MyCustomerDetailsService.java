package com.example.finalprojecbackend.service;

import com.example.finalprojecbackend.model.Customer;
import com.example.finalprojecbackend.model.Merchant;
import com.example.finalprojecbackend.repository.authCustomerRepository;
import com.example.finalprojecbackend.repository.authMerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyCustomerDetailsService implements UserDetailsService {

    public final authCustomerRepository authcustomerrepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = authcustomerrepository.findUserByUsername(username);

        if (customer==null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return customer;
    }
}

